/*
* BaseException.java Created on Nov 13, 2011
* Copyright 2011@Snail Bao.
* All right reserved. 
*/
package com.exception;

import com.util.MessageUtils;



/**
 * 业务异常基类
 * @date Nov 13, 2011 11:27:58 PM

 */
public class BaseException extends Exception {
	/**
     * Constructs a new exception with <code>null</code> as its detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized, and may subsequently be initialized by a call to
     * {@link #initCause}.
     *
     * @param message
     *            the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()}method.
     */
    public BaseException(String message) {
    	super(MessageUtils.getMessage(message));
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not </i> automatically incorporated in this exception's detail
     * message.
     *
     * @param message
     *            the detail message (which is saved for later retrieval by the
     *            {@link #getMessage()}method).
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()}method). (A<tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message
     * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
     * contains the class and detail message of <tt>cause</tt>). This
     * constructor is useful for exceptions that are little more than wrappers
     * for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()}method). (A<tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructs a new exception with the specified detail message and parameter keys.
     * <p>
     * keys形式为new String[]{"我","你"}
     * 
     * @param message
     *            the detail message (which is saved for later retrieval by the
     *            {@link #getMessage()}method).
     * @param keys
     *            消息中的参数 为String 数组
     */
    public BaseException(String message, String[] keys) {
        super(MessageUtils.getMessage(message,keys));
    }
}
