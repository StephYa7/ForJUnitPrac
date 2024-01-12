package Prac_4.hotel;

public class BookingService {
    private HotelService hotelService;

    public BookingService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public boolean bookRoom(int roomId) {
        if (hotelService.isRoomAvailable(roomId)) {
            // Код, который бронирует номер.
            // Логика бронирования комнаты
            // В реальном приложении здесь бы было больше кода
            return true; // Номер забронирован
        } else {
            return false; // Номер не доступен
        }
    }

}