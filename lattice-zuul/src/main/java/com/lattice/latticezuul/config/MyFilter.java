package com.lattice.latticezuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 10:21
 **/
public class MyFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public String filterType() {
    //定义filter的类型，有pre、route、post、error四种
    return "pre";
  }

  @Override
  public int filterOrder() {

    //定义filter的顺序，数字越小表示顺序越高，越先执行
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    //表示是否需要执行该filter，true表示执行，false表示不执行
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    //filter需要执行的具体操作
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    String token = request.getParameter("token");
    System.out.println(token);
    if (token == null) {
      log.warn("token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is empty");
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }
    log.info("ok");
    return null;
  }
}
