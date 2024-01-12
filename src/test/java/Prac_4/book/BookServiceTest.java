package Prac_4.book;


import Prac_4.hotel.BookingService;
import Prac_4.hotel.HotelService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    void bookingServiceTest() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(3)).thenReturn(false);

        boolean result = bookingService.bookRoom(3);

        assertFalse(result);
    }
}