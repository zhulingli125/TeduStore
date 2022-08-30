package cn.tedu.store.bean;

public class Cart {
    public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "cart [id=" + id + ", goodsid=" + goodsid + ", userid=" + userid + ", count=" + count + "]";
	}

	private Integer id;

    private String goodsid;

    private Integer userid;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart(Integer id, String goodsid, Integer userid, Integer count) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.userid = userid;
		this.count = count;
	}
    public Cart(String goodsid, Integer userid, Integer count) {
		super();
		this.goodsid = goodsid;
		this.userid = userid;
		this.count = count;
	}

	public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}