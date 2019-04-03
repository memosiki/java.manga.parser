/*
Проект по скачиванию манги
Автор memosiki
 */
package apimangagui;

import static apimangagui.AddNew.chosenFile;
import static apimangagui.AddNew.chosenLink;
import static apimangagui.AddNew.chosenNames;
import static apimangagui.AddNew.chosenChapterStyle;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.TimerTask;
import java.util.Timer;

public class Apimanga {

    static char separator;

    static ImageIcon[] iconsArray;
    static int pagesCount;
    static int chaptersCount = 0;
    static String[] pagesLinks;//volatile только массив, т.е. его характеристики(нужная мне длина) но не его элементы
    static String[] chapterLinks;
    static String titleName;
    static String titleAltName = "";
    static String[] chapterNames;
    static String mangaURLAdress;
    static String serverURLAdress;
    static String mainPath;
    static String chapterPath;
    static boolean originalNames;
    static boolean chapterStyle;
    static File previousSession = new File("/temp");
    static int loadingCoverIndex;
    static boolean savingCovers = false;

    static String[] coversLinks = null;

    public void apimanga() throws InterruptedException {
        if (MainMenu.windowsPort) {
            separator = '\\';
        } else {
            separator = '/';
        }

        mainPath = chosenFile.toString();
        mangaURLAdress = chosenLink;//ссылка
        if (mangaURLAdress.charAt(mangaURLAdress.length() - 1) == '/') {
            mangaURLAdress = mangaURLAdress.substring(0, mangaURLAdress.length() - 1);
        }
        originalNames = !chosenNames;
        chapterStyle = chosenChapterStyle;

        serverURLAdress = mangaURLAdress.substring(0, mangaURLAdress.indexOf("/", mangaURLAdress.indexOf('.')));
        Thread.sleep(0);
        parseCovers();

        Thread.sleep(0);
        try {

            parser(mangaURLAdress);
        } catch (IOException ex) {
            MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, ex, "Ошибка при парсинге страницы.\nПравильная ссылка?  " + mangaURLAdress + "\nПроверьте соединение с интернетом\n");
        }
        //main folder
        File outFile = new File(mainPath);
        outFile.mkdirs();
        outFile = new File(mainPath + separator + titleAltName);
        if (!outFile.mkdir() && !outFile.exists()) {
            MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, "\nОшибка при создании файла\nPath:  " + outFile.getPath() + "\nAbs. path:  " + outFile.getAbsolutePath());
        }
        Thread.sleep(0);
        downloadAllPages();

    }

    void parser(String parsingURL) throws IOException {

        Document parsingDoc = Jsoup.connect(parsingURL).get();
        Elements chapters = parsingDoc.select("div[class=expandable chapters-link] a");
        titleName = parsingDoc.select("meta[itemprop=name]").toString();
//<meta itemprop="name" content="Фейри Тейл" />
//<meta itemprop="alternativeHeadline" content="Fairy Tail" />
        titleAltName = parsingDoc.select("meta[itemprop=alternativeHeadline]").toString();

        titleName = titleName.substring("<meta itemprop=\"name\" content=\"".length(), titleName.length() - 2);
        titleAltName = titleAltName.substring("<meta itemprop=\"alternativeHeadline\" content=\"".length(), titleAltName.length() - 2);
        titleName = clear(titleName);
        titleAltName = clear(titleAltName);

//System.out.print(chapters);
        Element temp;
        String[] tempString;
        for (int i = 0; i < chapters.size() / 2; i++) {//переворот массива глав(от начала к последней)
            temp = chapters.get(i);
            chapters.set(i, chapters.get(chapters.size() - i - 1));
            chapters.set(chapters.size() - i - 1, temp);
        }
        //<a href="/noragami/vol17/67" title=""> Бездомный Бог 17 - 67 Мое </a>
        chapterLinks = chapters.toString().substring(9).split("<a href=\"");//первый элемент пустой из-за разделителя спереди(кусаем разделитель)
        chapterNames = chapters.html().split("\n");//отбор названий из html

        for (int i = 0; i < chapterNames.length; i++) {
            if (chapterNames[i].contains("<sup>")) {
                chapterNames[i] = chapterNames[i].replace("<sup><span class=\"chapterNew\">новое</span></sup>", "");
            }

            chapterNames[i] = chapterNames[i].trim();
            chapterLinks[i] = chapterLinks[i].substring(0, chapterLinks[i].indexOf("\""));//со ссылками все просто
            //           /nice_to_meet_you__kami_sama/vol1/1
            chapterNames[i] = clear(chapterNames[i]);
            //длина          название
            /* 81  Судьба ночь схватки: Прикосновение Небес 3 - 11 Третий день - Сильнейший враг (2)
            83  Судьба ночь схватки: Прик… 3 - 12 Четвертый день - Война Святого Грааля, начало (1)
            83  Судьба ночь схватки: Прик… 3 - 13 Четвертый день - Война Святого Грааля, начало (2)
            83  Судьба ночь схватки: Прик… 3 - 14 Четвертый день - Война Святого Грааля, начало (3)
            83  Судьба ночь схватки: Прик… 3 - 15 Четвертый день - Война Святого Грааля, начало (4)
            79  Судьба ночь схватки: Прикосновение Небес 3 - 16 Четвертый день - Незваный гость*/
            //... System.out.println(chapterNames[i].length()+"  "+chapterNames[i]);
            //System.out.println(chapterNames[i].substring(0, titleName.length()));
            // System.out.println(titleName);
            if (!chapterNames[i].substring(0, titleName.length()).equals(titleName)) {
                for (int j = 0; j < titleName.length(); j++) {
                    if (chapterNames[i].charAt(j) != titleName.charAt(j)) {
                        chapterNames[i] = chapterNames[i].substring(j + 2);
                        break;
                    }
                }
            } else {
                chapterNames[i] = chapterNames[i].substring(titleName.length() + 1);
            } //название спереди+пробел 
            if (chapterStyle) {//добавка нулей
                tempString = chapterNames[i].split(" ");

                if (tempString[0].length() < 2) {
                    chapterNames[i] = "0" + chapterNames[i];
                }
                if (tempString.length > 2) {
                    if (tempString[2].length() < 3) {
                        if (tempString[2].length() < 2) {

                            chapterNames[i] = chapterNames[i].substring(0, 5).concat("00").concat(chapterNames[i].substring(5));//вставка нулей перед томами и главами 
                        } else {
                            chapterNames[i] = chapterNames[i].substring(0, 5).concat("0").concat(chapterNames[i].substring(5));//в названии папки для адекватной сотировки

                        }
                    }
                }
            }

        }

    }

    void loadPagesLinks(String URLadress) throws IOException {

        String tempHtmlFileName = mainPath + separator + titleAltName + separator + "assets" + separator + "tempHtml";//название временного файл с html
        byte[] buf = new byte[1024 * 4];  //буфер входящих данных
        String pagesLinksNotParsed = null;//строка со ссылками на страницу
        File tempHtmlFile;     //временный файл с html
        ArrayList<String> stringsTempHtmlFile = new ArrayList(); // vfccbd cnhjr 'njuj afqkf
        tempHtmlFile = new File(mainPath + separator + titleAltName + separator + "assets");
        tempHtmlFile.mkdirs();
        tempHtmlFile = new File(tempHtmlFileName);
        FileOutputStream outTempHtmlStream = new FileOutputStream(tempHtmlFile);

        URL url = new URL(URLadress);
        HttpURLConnection urlConnection;
        urlConnection = (HttpURLConnection) url.openConnection();
        try {

            int bufCount;//количество считанного в буфер
            InputStream inputData = new BufferedInputStream(urlConnection.getInputStream()); //скачивание страницы 

            while ((bufCount = inputData.read(buf)) > 0) {
                outTempHtmlStream.write(buf, 0, bufCount);
            }

            Files.lines(Paths.get(tempHtmlFileName), StandardCharsets.UTF_8).forEach(stringsTempHtmlFile::add);// считывание файла (ага в одну строку)
            for (int i = 0; i < stringsTempHtmlFile.size(); i++) {
                if (stringsTempHtmlFile.get(i).contains("rm_h.init")) { ///вся суть скачанной страницы
                    pagesLinksNotParsed = stringsTempHtmlFile.get(i);   //это ссылки на заветные картиночки
//                    rm_h.init( [['auto/01/65','http://e7.postfact.ru/',"/91/goldenwind_pozdravlyalka.jpg",800,800],['auto/01/65','http://e4.postfact.ru/',"/91/Ka                    
                    stringsTempHtmlFile.clear();
                }
            }

            outTempHtmlStream.close();
            tempHtmlFile.delete();//уборка
            tempHtmlFile = new File(mainPath + separator + titleAltName + separator + "assets");
            tempHtmlFile.delete();
        } finally {
            urlConnection.disconnect();
        }
        if (pagesLinksNotParsed == null) {
            MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, "Парсинг ссылок на страницы провалился\nБитая ссылка?:  " + URLadress);

        }
        String[] tempString;
        tempString = pagesLinksNotParsed.substring("  rm_h.init( [['".length()).split("\'");
        pagesLinks = new String[tempString.length / 4];
        for (int i = 3; i < tempString.length; i = i + 4) {
            tempString[i] = tempString[i].substring(tempString[i].indexOf('\"') + 1, tempString[i].lastIndexOf('\"'));//перебор составляющих
            pagesLinks[(i - 3) / 4] = tempString[i - 1] + tempString[i - 3] + tempString[i];
            //http://e6.postfact.ru   /auto/01/65/91   /Kamisama_v01_ch01_001.jpg_res.jpg
        }

    }

    void downloadPages() throws InterruptedException {

        byte[] buf = new byte[1024 * 4];//буфер на 4 кб        
        int bufCount; // размер буфера
        URL url; //URL картинки
        File pictureFile; //файл картинки
        HttpURLConnection urlConnection = null;//соединение
        InputStream inputData;//входной поток из нтеренета
        pagesCount = 0;//счетчик страниц обнуляется на новой главе

        for (String pageLink : pagesLinks) {
            Thread.sleep(0);//если поток не остановлен
            // определение имен

            if (AddNew.oneFolderManga) {
                pictureFile = new File(chapterPath + separator + fillZero(chaptersCount, 3) + '.' + fillZero(pagesCount, 3) + pageLink.substring(pageLink.length() - 4));
            } else if (originalNames) {
                pictureFile = new File(chapterPath + separator + pageLink.substring(pageLink.lastIndexOf('/')));
            } else {
                pictureFile = new File(chapterPath + separator + fillZero(pagesCount, 3) + pageLink.substring(pageLink.length() - 4));
            }

            //открытие портала к картинкам
            try {
                FileOutputStream outPictureStream = new FileOutputStream(pictureFile);
                url = new URL(pageLink);
                urlConnection = (HttpURLConnection) url.openConnection();

                inputData = urlConnection.getInputStream();
                while ((bufCount = inputData.read(buf)) > 0) {
                    outPictureStream.write(buf, 0, bufCount);
                    //скачивание картиночки
                }
                outPictureStream.close();

            } catch (Exception ex) {
                MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, ex, "Ошибка при загрузке страницы.\n"
                        + "Проверьте соединение с Интернетом.\n"
                        + "Если уже загрузилось что-то, то попробуйте перейти по ссылкам\n"
                        + "Возможны технические работы на серверах(да, такоe бывает)\n"
                        + "Подождите и попробуйте снова.\n"
                        + "Возможно, при смене серверов, администрация забыла об этой страничке, что означает,что она утеряна.\n"
                        + "В любом случае отпишитесь мне.");
            } finally {
                urlConnection.disconnect();
            }
            pagesCount++;
        }
        Thread.sleep(1000);//ожидание обновления графической оболочки

    }

    void downloadAllPages() throws InterruptedException {
        File outFile;
        // все в одну папку
        chapterPath = mainPath + separator + titleAltName;
        while (chaptersCount < chapterLinks.length) {
            Thread.sleep(0);
            if (!AddNew.oneFolderManga) {
                chapterPath = mainPath + separator + titleAltName + separator + chapterNames[chaptersCount];
                outFile = new File(chapterPath);
                outFile.mkdir();
            }

            try {
                loadPagesLinks(serverURLAdress + chapterLinks[chaptersCount] + "?mature=1");
                //?mature= приписка для манги с возрастным ограничением
                // игнорируема остальными
            } catch (IOException ex) {
                MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, ex, "Ошибка при загрузке ссылок на страницы (Сломано?)");

            }

            downloadPages();

            chaptersCount++;

        }
        chaptersCount++;
    }

    public void parseCovers() throws InterruptedException {
        //парсинг ссылочек
        String[] coversLinksTemp = null;
        int indexAmp;
        boolean noCovers = false;
        try {
            Document parsingDoc = Jsoup.connect(mangaURLAdress).get();
            titleName = parsingDoc.select("meta[itemprop=name]").toString();
            titleAltName = parsingDoc.select("meta[itemprop=alternativeHeadline]").toString();
            titleName = titleName.substring("<meta itemprop=\"name\" content=\"".length(), titleName.length() - 2);
            titleAltName = parsingDoc.select("meta[itemprop=alternativeHeadline]").toString();
            Elements coversLinksNotParsed = parsingDoc.select("div[class=flex-row] div[class=picture-fotorama] img, div[class=flex-row] div[class=picture-fotorama] a");
            //нужно для сохранения обложек
            titleAltName = titleAltName.substring("<meta itemprop=\"alternativeHeadline\" content=\"".length(), titleAltName.length() - 2);
            titleAltName = clear(titleAltName);//линукс
            titleName = clear(titleName);
            if (titleName.length() > 20) {// определение размера обложки в зависимости от длины назвния т.е 2 существуют и 1 из них будет пустой
                ProgressAdd.jLabel11 = ProgressAdd.jLabel5;
            }
            //ProgressAdd.jLabel11  главная
            // в каждой строчке ссылки и на иконку и на обложку
            coversLinksTemp = coversLinksNotParsed.toString().split("\n");

            //  System.out.println(Arrays.toString(coversLinksTemp));
            int scaledW;
            int scaledH = ProgressAdd.jLabel11.getHeight();
            Image loadedCover;
            String iconPath;
            ImageScaler imageScaler = new ImageScaler();//обсерв для изображений
            //нужен только для конструктора высоты и ширины иконок
            Random luckyOne = new Random();

            if (AddNew.browseCovers) {
                if (coversLinksTemp.length > 1) {//нет обложек - ничего не надо делать
                    int iconCount = -1;
                    iconsArray = new ImageIcon[coversLinksTemp.length];
                    for (String coverLinkTemp : coversLinksTemp) {
                        Thread.sleep(0);
                        iconCount++;
                        if (coverLinkTemp.contains("src=\"")) {
                            indexAmp = coverLinkTemp.indexOf("src=\"") + "src=\"".length();
                        } else {
                            indexAmp = coverLinkTemp.indexOf("<a href=\"") + "<a href=\"".length();
                        }

                        iconPath = coverLinkTemp.substring(indexAmp, coverLinkTemp.indexOf('\"', indexAmp));
                        loadedCover = ImageIO.read(new URL(iconPath));

                        scaledW = loadedCover.getWidth(imageScaler) * scaledH / loadedCover.getHeight(imageScaler);

                        iconsArray[iconCount] = new ImageIcon(loadedCover.getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH));

                    }
                    changeIconBytime.iconsChanger = new Timer();
                    changeIconBytime.iconsChanger.scheduleAtFixedRate(new changeIconBytime(), 0, changeIconBytime.iconsWait);
                    changeIconBytime.iterateUp();
                }
            } else {
                if (coversLinksTemp.length > 1) {
                    System.out.println("apimangagui.Apimanga.parseCovers()");
                    iconPath = coversLinksTemp[luckyOne.nextInt(coversLinksTemp.length - 1)];//случайная обложка
                } else if (coversLinksTemp.length == 0) {
                    noCovers = true;
                    iconPath = "";//нет обложек
                } else {
                    iconPath = coversLinksTemp[0];// единственная обложка
                }
                if (!noCovers) {// если есть обложки то они ставятся
                    if (iconPath.contains("src=\"")) {
                        indexAmp = iconPath.indexOf("src=\"") + "src=\"".length();
                    } else {
                        indexAmp = iconPath.indexOf("<a href=\"") + "<a href=\"".length();
                    }
                    iconPath = iconPath.substring(indexAmp, iconPath.indexOf('\"', indexAmp));
                    loadedCover = ImageIO.read(new URL(iconPath));
                    scaledW = loadedCover.getWidth(imageScaler) * scaledH / loadedCover.getHeight(imageScaler);
                    loadedCover = loadedCover.getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
                    ProgressAdd.jLabel11.setIcon(new ImageIcon(loadedCover));
                }
            }

        } catch (IOException ex) {
            MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, ex, "Ошибка парсинга обложек/иконок");
        }

        ProgressAdd.jProgressBar1.setIndeterminate(false);
        ProgressAdd.jProgressBar1.setStringPainted(true);
        if (AddNew.saveCovers) {
            savingCovers = true;
            //парсинг ссылок
            int coverCount = -1;
            coversLinks = new String[coversLinksTemp.length];
            for (String coverLinkTemp : coversLinksTemp) {

                coverCount++;
                indexAmp = coverLinkTemp.indexOf("data-full=\"") + "data-full=\"".length();
                coversLinks[coverCount] = coverLinkTemp.substring(indexAmp, coverLinkTemp.indexOf('\"', indexAmp));
            }

            // запуск счетчика
            ProcentCovers procentCoversTask = new ProcentCovers();
            procentCoversTask.addPropertyChangeListener(MainMenu.addNewFrame);
            procentCoversTask.execute();
            ProgressAdd.jLabel9.setText("Загрузка обложек");
            ProgressAdd.jLabel3.setText("");
            byte[] buf = new byte[1024 * 4];//буфер на 4 кб        
            int bufCount; // размер буфера
            URL url; //URL картинки
            File pictureFile; //файл картинки
            HttpURLConnection urlConnection = null;//соединение
            InputStream inputData;//входной поток из нтеренета
            String coverPath = mainPath + separator + titleAltName + separator + "Обложки";

            pictureFile = new File(coverPath);
            pictureFile.mkdirs();
            for (loadingCoverIndex = 0; loadingCoverIndex < coversLinks.length; loadingCoverIndex++) {
                Thread.sleep(0);

                try {
                    pictureFile = new File(coverPath + '/' + coversLinks[loadingCoverIndex].substring(coversLinks[loadingCoverIndex].lastIndexOf("/")));
                    FileOutputStream outPictureStream = new FileOutputStream(pictureFile);

                    url = new URL(coversLinks[loadingCoverIndex]);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    inputData = urlConnection.getInputStream();
                    while ((bufCount = inputData.read(buf)) > 0) {
                        outPictureStream.write(buf, 0, bufCount);
                        //скачивание картиночки
                    }
                    outPictureStream.close();

                } catch (Exception ex) {
                    MainMenu.progressAddFrame.ThrowErr(MainMenu.progressAddFrame, ex, "Ошибка при загрузке обложки", "#  " + loadingCoverIndex + "\nИмя " + coversLinks[loadingCoverIndex]);

                } finally {
                    urlConnection.disconnect();
                }

            }
            loadingCoverIndex++;//для таска обложек
        }

        ProcentChapters procentChaptersTask = new ProcentChapters();

        procentChaptersTask.addPropertyChangeListener(MainMenu.addNewFrame);

        procentChaptersTask.execute();

        ProgressAdd.jLabel9.setText(Apimanga.titleName);

    }

    String clear(String dirt) {
        if (MainMenu.windowsPort) {
            dirt = dirt.replace('\\', ' ');

            dirt = dirt.replace(':', ' ');
            dirt = dirt.replace('*', ' ');
            dirt = dirt.replace('?', ' ');
            dirt = dirt.replace('"', ' ');
            dirt = dirt.replace('<', ' ');
            dirt = dirt.replace('>', ' ');
            dirt = dirt.replace('|', ' ');
            dirt = dirt.replace('+', ' ');
            dirt = dirt.replace('.', ' ');
        }
        dirt = dirt.replace('/', ' ');
        dirt = dirt.trim();// для линукса все проще
        return (dirt);

    }

    String fillZero(int number, int pos) {
        String zeroes = "";
        if (Integer.toString(number).length() > pos) {
            return (Integer.toString(number));
        } else {
            for (int i = 0; i < pos; i++) {
                zeroes += '0';
            }
            return (zeroes.substring(Integer.toString(number).length()) + number);
        }
    }

    
}

class ImageScaler implements ImageObserver {

    @Override
    public boolean imageUpdate(Image image, int i, int i1, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//неебу что как это 
    //работает и ладно
}
