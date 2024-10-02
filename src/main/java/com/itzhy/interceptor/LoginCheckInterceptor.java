package com.itzhy.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itzhy.pojo.Result;
import com.itzhy.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//拦截器
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Override//目标运行前true放行 false不放行
   public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("preHandle");

       //获取请求url
       String url=   req.getRequestURI();
       log.info("请求的url:{}",url);

        //判断url是否包含login有就是登录操作，放行
        if(true)//url.contains("login")|| url.contains("register")
        {
            log.info("登录操作放行");
           //放行操作
          return true;
        }
       //获取请求头中的令牌（token）
      String jwt = req.getHeader("Authorization");


      //判断令牌是否存在，不存在返回错误结果(未登录)
       if(!StringUtils.hasLength(jwt))
        {
           log.info("请求头token为空，返回未登录的信息");
           Result error=   Result.error("NOT_LOGIN");
            //手动转换将返回对象转为jason引入阿里巴巴的工具箱fastJson
           String noLogin=  JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);//响应未登录的结果
           return false;
       }
        //解析token，如果解析失败返回错误结果(未登录)

       try {
           JwtUtils.parseJWT(jwt);
       } catch (Exception e) {//解析失败
           e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");

           Result error=   Result.error("NOT_LOGIN");
            //手动转换将返回对象转为jason引入阿里巴巴的工具箱fastJson
            String noLogin=  JSONObject.toJSONString(error);
           resp.getWriter().write(noLogin);//响应未登录的结果
           return false;
       }

        //放行
        log.info("令牌合法，放行");
       return true;

    }

   @Override//运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }

    @Override//视图渲染完毕后运行，最后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}

