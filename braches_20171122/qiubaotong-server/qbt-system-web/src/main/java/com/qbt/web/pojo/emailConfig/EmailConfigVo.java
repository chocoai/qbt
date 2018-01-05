package com.qbt.web.pojo.emailConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

public class EmailConfigVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
	@NotNull(message = "平台不能为空")
    private String platform;
	
	@NotNull(message = "唯一标识码")
    private String code;
	
	@NotNull(message = "名称不能为空")
    private String name;
	
	@NotNull(message = "邮箱主机不能为空")
    private String host;
	
	@NotNull(message = "邮箱端口不能为空")
    private String port;
	
	@NotNull(message = "邮箱用户名不能为空")
    private String username;
	
	@NotNull(message = "邮箱密码不能为空")
    private String password;

	@NotNull(message = "发送者邮箱不能为空")
    private String sendFrom;
    
    private List<String> sendTo = new ArrayList<String>();

    private List<String> sendToCc = new ArrayList<String>();

    private Integer operatorId;

    private String operatorName;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username = username == null ? null : username.trim();
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom == null ? null : sendFrom.trim();
    }
    
    public List<String> getSendTo() {
		return sendTo;
	}

	public void setSendTo(List<String> sendTo) {
		this.sendTo = sendTo;
	}

	public List<String> getSendToCc() {
		return sendToCc;
	}

	public void setSendToCc(List<String> sendToCc) {
		this.sendToCc = sendToCc;
	}

	public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }
}