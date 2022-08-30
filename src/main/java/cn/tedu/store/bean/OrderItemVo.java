package cn.tedu.store.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderItemVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String image;

    private String title;

    private Integer price;

    private Integer count;

    private Integer paymentstatus;
    
    private Date tradetime;
    
    private Integer orderstatus;

    private Integer orderid;
    
    private Integer orderitemid;
    private String showTime;

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(Integer paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Date getTradetime() {
		return tradetime;
	}

	public void setTradetime(Date tradetime) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		showTime=sdf.format(tradetime);
		this.tradetime = tradetime;
	}

	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((orderitemid == null) ? 0 : orderitemid.hashCode());
		result = prime * result + ((orderstatus == null) ? 0 : orderstatus.hashCode());
		result = prime * result + ((paymentstatus == null) ? 0 : paymentstatus.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tradetime == null) ? 0 : tradetime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemVo other = (OrderItemVo) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (orderitemid == null) {
			if (other.orderitemid != null)
				return false;
		} else if (!orderitemid.equals(other.orderitemid))
			return false;
		if (orderstatus == null) {
			if (other.orderstatus != null)
				return false;
		} else if (!orderstatus.equals(other.orderstatus))
			return false;
		if (paymentstatus == null) {
			if (other.paymentstatus != null)
				return false;
		} else if (!paymentstatus.equals(other.paymentstatus))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tradetime == null) {
			if (other.tradetime != null)
				return false;
		} else if (!tradetime.equals(other.tradetime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItemVo [image=" + image + ", title=" + title + ", price=" + price + ", count=" + count
				+ ", paymentstatus=" + paymentstatus + ", tradetime=" + tradetime + ", orderstatus=" + orderstatus
				+ ", orderid=" + orderid + ", orderitemid=" + orderitemid + "]";
	}

	public OrderItemVo(String image, String title, Integer price, Integer count, Integer paymentstatus, Date tradetime,
			Integer orderstatus, Integer orderid, Integer orderitemid) {
		super();
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.paymentstatus = paymentstatus;
		this.tradetime = tradetime;
		this.orderstatus = orderstatus;
		this.orderid = orderid;
		this.orderitemid = orderitemid;
	}
    
    public OrderItemVo() {
		// TODO Auto-generated constructor stub
	}

}
