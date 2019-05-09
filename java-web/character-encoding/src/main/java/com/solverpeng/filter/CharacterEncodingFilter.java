package com.solverpeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;
    private boolean forceRequestEncoding;
    private boolean forceResponseEncoding;

    public CharacterEncodingFilter() {
        this.forceRequestEncoding = false;
        this.forceResponseEncoding = false;
    }

    public CharacterEncodingFilter(String encoding) {
        this(encoding, false);
    }

    public CharacterEncodingFilter(String encoding, boolean forceEncoding) {
        this(encoding, forceEncoding, forceEncoding);
    }

    public CharacterEncodingFilter(String encoding, boolean forceRequestEncoding, boolean forceResponseEncoding) {
        this.forceRequestEncoding = false;
        this.forceResponseEncoding = false;
        this.encoding = encoding;
        this.forceRequestEncoding = forceRequestEncoding;
        this.forceResponseEncoding = forceResponseEncoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setForceEncoding(boolean forceEncoding) {
        this.forceRequestEncoding = forceEncoding;
        this.forceResponseEncoding = forceEncoding;
    }

    public void setForceRequestEncoding(boolean forceRequestEncoding) {
        this.forceRequestEncoding = forceRequestEncoding;
    }

    public boolean isForceRequestEncoding() {
        return this.forceRequestEncoding;
    }

    public void setForceResponseEncoding(boolean forceResponseEncoding) {
        this.forceResponseEncoding = forceResponseEncoding;
    }

    public boolean isForceResponseEncoding() {
        return this.forceResponseEncoding;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String encoding = this.getEncoding();
        if (encoding != null) {
            if (this.isForceRequestEncoding() || httpServletRequest.getCharacterEncoding() == null) {
                httpServletRequest.setCharacterEncoding(encoding);
            }

            if (this.isForceResponseEncoding()) {
                httpServletResponse.setCharacterEncoding(encoding);
            }
        }

        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        this.forceRequestEncoding = Boolean.parseBoolean(filterConfig.getInitParameter("forceRequestEncoding"));
        this.forceResponseEncoding = Boolean.parseBoolean(filterConfig.getInitParameter("forceResponseEncoding"));
    }

    @Override
    public void destroy() {
    }
}
