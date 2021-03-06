package com.svnlike.api.model.po;

import com.svnlike.utils.model.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * svn server
 * @author zhangkx
 */
@Getter
@Setter
public class SvnServerPO extends BaseBean {

    /**
     * ID
     */
    private Integer id;

    /**
     * domain
     */
    private String domain;

    /**
     * IP
     */
    private String ip;

    /**
     * description
     */
    private String description;

    /**
     * ssh account
     */
    private String sshAccount;

    /**
     * ssh password
     */
    private String sshPassword;

    /**
     * is enabled
     */
    private Integer isEnabled;

    /**
     * created at
     */
    private Date createdAt;

    /**
     * updated at
     */
    private Date updatedAt;
}
