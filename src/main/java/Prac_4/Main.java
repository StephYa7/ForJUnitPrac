package Prac_4;

import Prac_4.book.Book;
import Prac_4.book.BookRepository;
import Prac_4.book.BookService;
import Prac_4.book.InMemoryBookRepository;
import Prac_4.database.DataProcessor;
import Prac_4.database.Database;
import Prac_4.hotel.BookingService;
import Prac_4.hotel.HotelService;
import Prac_4.message.MessageService;
import Prac_4.message.NotificationService;
import Prac_4.weather.WeatherReporter;
import Prac_4.weather.WeatherService;

import Prac_4.weather.WeatherReporter;
import Prac_4.weather.WeatherService;

import java.util.List;

public class Main {


    //**
    // 4.3. Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
    // обращающийся к внешнему API для получения информации о текущей температуре.
    // Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
    // Создайте мок-объект для WeatherService с использованием Mockito.
    // *

    public static void main(String[] args) {
        // Создаем объект WeatherService. В реальной программе, этот класс
        // бы обращался к внешнему API для получения температуры.
        WeatherService weatherService = new WeatherService();

        // Создаем объект WeatherReporter, передаем ему WeatherService в конструктор.
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        // Получаем отчет о погоде.
        String report = weatherReporter.generateReport();

        // Выводим отчет на консоль.
        System.out.println(report);

    }


    //*
// 4.4.
//Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
//        Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId), который обычно проверяет, доступен ли номер в отеле.
//Вам необходимо проверить правильность работы класса BookingService, который использует HotelService для бронирования номера, если он доступен.
// *
//    public static void main(String[] args) {
//
//        // Создание реального экземпляра HotelService
//        HotelService realHotelService = new HotelService();
//
//        // Создание экземпляра BookingService с реальным HotelService
//        BookingService bookingService = new BookingService(realHotelService);
//
//        // Пытаемся забронировать доступный номер (например, номер 2)
//        if (bookingService.bookRoom(2)) {
//            System.out.println("Успешно забронирован номер 2!");
//        } else {
//            System.out.println("Не удалось забронировать номер 2.");
//        }
//
//        // Пытаемся забронировать недоступный номер (например, номер 3)
//        if (bookingService.bookRoom(3)) {
//            System.out.println("Успешно забронирован номер 3!");
//        } else {
//            System.out.println("Не удалось забронировать номер 3.");
//        }
//    }





















    /*
      4.5. Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
      Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String recipient),
      который отправляет сообщение получателю.
      Вам необходимо проверить правильность работы класса NotificationService,
      который использует MessageService для отправки уведомлений.
    */
//    public static void main(String[] args) {
//        MessageService messageService = new MessageService();
//        NotificationService notificationService = new NotificationService(messageService);
//
//        notificationService.sendNotification("Привет!", "Анна");
//    }


























    /*
        4.6.Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
        Условие: У вас есть класс Database с методом public List<String> query(String sql),
        который выполняет SQL-запрос и возвращает результат.
        Вам необходимо проверить правильность работы класса DataProcessor, который использует
        Database для выполнения запроса и обработки результатов.

     */
//    public static void main(String[] args) {
//        // Создаём экземпляр класса Database
//        Database database = new Database();
//
//        // Создаём экземпляр класса DataProcessor, передавая в конструктор database
//        DataProcessor dataProcessor = new DataProcessor(database);
//
//        // Вызываем метод processData и выводим результаты
//        List<String> data = dataProcessor.processData("SELECT * FROM table");
//        for (String datum : data) {
//            System.out.println(datum);
//        }
//    }



















    /*
     * HW4.3. У вас есть класс BookService, который использует интерфейс BookRepository
     * для получения информации о книгах из базы данных.
     *  Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
     * */
//    public static void main(String[] args) {
//        BookRepository repository = new InMemoryBookRepository();
//        BookService bookService = new BookService(repository);
//
//        Book book1 = bookService.findBookById("1");
//        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());
//
//        List<Book> allBooks = bookService.findAllBooks();
//        System.out.println("Все книги:");
//        for (Book book : allBooks) {
//            System.out.println("- " + book.getTitle() + " от " + book.getAuthor());
//        }
//    }
}