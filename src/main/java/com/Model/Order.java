package com.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service 
@Component 
@Entity(name="Orders")
public class Order implements Serializable{
			
		@GeneratedValue
		@Id
		@Column(name="orderId")
		private int orderId;
		
		@ManyToOne
		@JoinColumn(name="email")
		private User user;
		
		@Column(name="paymentMode")
		private String paymentMode;
		
		@Column(name="totalAmount")
		private double totalAmount;
		
		public Order(){super();}

		public Order(int orderId, User user, String paymentMode, double totalAmount) {
			super();
			this.orderId = orderId;
			this.user = user;
			this.paymentMode = paymentMode;
			this.totalAmount = totalAmount;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

}