package cn.tedu.store.bean;

public class OrderItem {
    private Integer id;

    private Integer userid;

    private String goodsid;

    private String image;

    private String title;

    private Integer price;

    private Integer count;

    private Integer paymentstatus;

    private Integer orderstatus;

    private Integer orderid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", userid=" + userid + ", goodsid=" + goodsid + ", image=" + image + ", title="
				+ title + ", price=" + price + ", count=" + count + ", paymentstatus=" + paymentstatus
				+ ", orderstatus=" + orderstatus + ", orderid=" + orderid + "]";
	}

	public OrderItem(Integer id, Integer userid, String goodsid, String image, String title, Integer price,
			Integer count, Integer paymentstatus, Integer orderstatus, Integer orderid) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.paymentstatus = paymentstatus;
		this.orderstatus = orderstatus;
		this.orderid = orderid;
	}
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((goodsid == null) ? 0 : goodsid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((orderstatus == null) ? 0 : orderstatus.hashCode());
		result = prime * result + ((paymentstatus == null) ? 0 : paymentstatus.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (goodsid == null) {
			if (other.goodsid != null)
				return false;
		} else if (!goodsid.equals(other.goodsid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
    
}