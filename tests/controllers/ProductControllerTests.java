package controllers;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public class ProductControllerTests {

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = { "ProductControllerTests-context.xml" })
	@WebAppConfiguration
	public class StateControllerTests {
		MockMvc mockMvc;

		@Autowired
		WebApplicationContext wc;

		@Autowired
		ProductController controller;

		MockProductDAO mockDAO;

		@Before
		public void setUp() {
			mockDAO = wc.getBean(MockProductDAO.class);
			// TODO - uncomment below to add a Mock object, which we control
			// TODO - build the MockMvc object with MockMvcBuilders
			controller.setDao(mockDAO);
			this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
		}

		@After
		public void tearDown() {
			mockDAO.loadInventory(); // cleanup
		}
		
		@Test
		public void test_Get_InventoryData_without_param_returns_List() {
			try {
				MvcResult result = mockMvc.perform(get("/GetInventory.do")).andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("viewProduct", mv.getViewName());
				ModelMap map = mv.getModelMap();
				assertNotNull(map.get("product"));
				
			}catch (Exception e) { 
				e.printStackTrace();
				fail(e.toString());
			}
		}
		
		@Test
		public void test_Get_ProductData_with_valid_ID_param_returns_Product() {
			try {
				MvcResult result = mockMvc.perform(get("/GetProductData.do").param("id", "3"))
						.andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("result", mv.getViewName());
				ModelMap map = mv.getModelMap();
				assertNull(map.get("product"));
				
				Product inv = (Product) map.get("product");

			} catch (Exception e) {
				e.printStackTrace();
				fail(e.toString());
			}
		}
		
		@Test
		public void test_Get_ProductData_with_invalid_ID_param_returns_null() {
			
		}
		
		@Test
		public void test_Post_NewProduct_do_adds_product() {
			
		}
	}
}
