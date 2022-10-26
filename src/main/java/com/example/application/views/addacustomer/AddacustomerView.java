package com.example.application.views.addacustomer;

import com.example.application.data.entity.Customer;
import com.example.application.data.service.CustomerService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Add a customer")
@Route(value = "library/login", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class AddacustomerView extends VerticalLayout {

	private final CustomerService customerService;
	
    public AddacustomerView(CustomerService customerService) {    	
    	this.customerService = customerService;
        setSpacing(false);
        
        TextField name = new TextField("Name");
        TextField surname = new TextField("Surname");
        Button addCustomer = new Button("Add");
        
        addCustomer.addClickListener(e->{
        	if(name.getValue().equals("") || surname.getValue().equals("")) {
        		Notification notification = Notification.show("Fill in customer's info");
            	//	add(new Notification("Fill in customer's info"));
            		add(notification);       		
        	}else {
        		Customer customer = new Customer();
        		customer.setFirstName(name.getValue());
        		customer.setLastName(surname.getValue());
        		customerService.addCustomer(customer);
        	}
        });
        
/*        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);
*/
        add(new H2("Add a new customer:"));
        add(name);
        add(surname);
        add(addCustomer);
//        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

//        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
