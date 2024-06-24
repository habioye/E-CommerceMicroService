package com.genspark.ItemService;

import com.genspark.ItemService.Service.ItemService;
import com.genspark.ItemService.controller.ItemsController;
import com.genspark.ItemService.entity.Items;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItemServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void test_returns_list_of_items_for_valid_vendorId() {
		// Arrange
		ItemService mockService = mock(ItemService.class);
		ItemsController controller = new ItemsController();
		ReflectionTestUtils.setField(controller, "service", mockService);
		List<Items> expectedItems = Arrays.asList(new Items(), new Items());
		when(mockService.getByVendorId(1)).thenReturn(expectedItems);

		// Act
		List<Items> actualItems = controller.findByVendorId(1);

		// Assert
		assertEquals(expectedItems, actualItems);
	}

}
