package com.zps.qr.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="codes")
public class Code {
	
	 /**
     * Fields
     */
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mId;
	
	private int mUserId;
	
    //@Column(name = "mcontent")
	private String mContent;
	
	private String mDescribe;
	
    //@Column(name = "mtype")
    private int mType;
    //@Column(name = "mcodeimagepath")
    @Column(nullable = false)
    private String mCodeImagePath;
    
    private byte[] mCodeImg; 
    
    //@Column(name = "mtimestamp")
    private long mTimeStamp;
    
    private String mDName;
    
    private String mDSerial;
    
    
    /* Constructor */
    
    public Code() {
		//super();
		
	}
    
    public Code(long id , int userId, String mContent, String mDescribe, int mType, String mCodeImagePath, byte[] mCodeImg, long mTimeStamp, String mDName, String mDSerial) {
		//super();
		this.mId = id;
		this.mUserId = userId;
		this.mContent = mContent;
		this.mDescribe = mDescribe;
		this.mType = mType;
		this.mCodeImagePath = mCodeImagePath;
		this.mCodeImg = mCodeImg;
		this.mTimeStamp = mTimeStamp;
		this.mDName = mDName;
		this.mDSerial = mDSerial;
	}
    
    

	/* Getters */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid", nullable = false)
    public long getmId() {
  		return mId;
  	}
    
    public void setmId(long id) {
  		this.mId = id;
  	}
    
    @Column(name = "muserid", nullable = false)
    public int getmUserId() {
		return mUserId;
	}

	public void setmUserId(int userId) {
		this.mUserId = userId;
	}
    
    
    @Column(name = "mcontent", nullable = false)
    public String getmContent() {
  		return mContent;
  	}
    
    public void setmContent(String mContent) {
  		this.mContent = mContent;
  	}
    
    @Column(name = "mdescribe", nullable = false)
	public String getmDescribe() {
		return mDescribe;
	}

	public void setmDescribe(String mDescribe) {
		this.mDescribe = mDescribe;
	}
    
    @Column(name = "mtype", nullable = false) 
    public int getmType() {
  		return mType;
  	}
    
    public void setmType(int mType) {
  		this.mType = mType;
  	}
    @Column(name = "mcodeimagepath", nullable = false)
    public String getmCodeImagePath() {
  		return mCodeImagePath;
  	}
    
    public void setmCodeImagePath(String mCodeImagePath) {
  		this.mCodeImagePath = mCodeImagePath;
  	}
    
    @Column(name = "mtimestamp", nullable = false)
    public long getmTimeStamp() {
  		return mTimeStamp;
  	}
    
    public void setmTimeStamp(long mTimeStamp) {
  		this.mTimeStamp = mTimeStamp;
  	}
    
    @Column(name = "mdname", nullable = false)
    public String getmDName() {
		return mDName;
	}

	public void setmDName(String mDName) {
		this.mDName = mDName;
	}
	 @Column(name = "mdserial", nullable = false)
	public String getmDSerial() {
		return mDSerial;
	}

	public void setmDSerial(String mDSerial) {
		this.mDSerial = mDSerial;
	}
	
	@Column(name = "mcodeimg", nullable = false)
	public byte[] getmCodeImg() {
		return mCodeImg;
	}

	public void setmCodeImg(byte[] mCodeImg) {
		this.mCodeImg = mCodeImg;
	}
	
	
   
 
  	/** To String method override **/
  	@Override
	public String toString() {
		return "Code [mId=" + mId + "mUserId=" + mUserId +", mcontent=" + mContent +  "mDescribe="+mDescribe+ ", mtype=" + mType + ", mcodeimagepath=" + mCodeImagePath
				+ ", mcodeimg=" + mCodeImg + ", mtimestamp=" + mTimeStamp +"mDName=" + mDName + "mDSerial=" + mDSerial +
				 "]";
	}

}
