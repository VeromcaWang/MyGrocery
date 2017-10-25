package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.manager.PurchaseManager;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
//	public Inventory getAvailableInventory()
//	{
//		InventoryService service = ServiceLocator.getInventoryService();
//		System.out.println("aaa");
//		return service.getAvailableInventory();
//	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public void printHello(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		response.getWriter().println("Hello World Spring MVC!");
//	}
	
//	@RequestMapping(path = "/new", method = RequestMethod.GET)
//	public String printHelloNew() throws Exception {
//		return "HelloJSP";
		
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PurchaseManager purchaseManager = new PurchaseManager();
		Order order = purchaseManager.createOrder();
		request.setAttribute("order", order);
		
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ModelAndView submitItems(@ModelAttribute Order order, HttpServletRequest request) {
		for (Item item : order.getItems())
			System.out.println(item.getName() + "   " + item.getQuantity());
		request.getSession().setAttribute("order", order);
//		Order sessionOrder = (Order) request.getSession().getAttribute("order");
//		this.getAvailableInventory();
		
		
		OrderProcessingServiceBean orderProcessingService = ServiceLocator.getOrderProcessingService();
		if(orderProcessingService.validateItemAvailability(order)) return new ModelAndView("redirect:/purchase/paymentEntry");
		return new ModelAndView("redirect:/purchase");
//		return new ModelAndView("redirect:/purchase/paymentEntry");
	}
	
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ModelAndView submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return new ModelAndView("redirect:/purchase/shippingEntry");
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ModelAndView submitPayment(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shipping);
		return new ModelAndView("redirect:/purchase/viewOrder");
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("order", (Order)request.getSession().getAttribute("order"));
		request.setAttribute("payment", (PaymentInfo)request.getSession().getAttribute("payment"));
		request.setAttribute("shipping", (ShippingInfo)request.getSession().getAttribute("shipping"));	
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ModelAndView confirmOrder(@ModelAttribute("confirm") Order order, HttpServletRequest request) {
		OrderProcessingServiceBean orderProcessing = ServiceLocator.getOrderProcessingService();
		String confirmationCode = orderProcessing.processOrder(order);
		request.getSession().setAttribute("confirmationCode", confirmationCode);
		request.setAttribute("confirmationCode", confirmationCode);
		return new ModelAndView("redirect:viewOrderConfirmation");
	}

	@RequestMapping(path = "/viewOrderConfirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("code", request.getSession().getAttribute("confirmationCode"));	
		return "Confirmation";
	}
}