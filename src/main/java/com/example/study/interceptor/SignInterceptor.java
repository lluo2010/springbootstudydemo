package com.example.study.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: zzqfsy
 * @Description:
 * @Date: Created in 18:09 2018/5/22
 * @Modified By:
 **/
@Component
public class SignInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(SignInterceptor.class);
    /*
    @Autowired
    private RedisCacheDB1Service redisCacheService;
    */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*if (request.getContentType().startsWith(ContentType.APPLICATION_JSON.getMimeType())){
            String body = IOUtils.toString(request.getInputStream());
            Map<String, Object> params = JSONObject.parseObject(body);
            verifySign(params);
        } else if (request.getContentType().startsWith(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())){
            verifySign(TransformUtils.Map2MapForParseValue(request.getParameterMap()));
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void verifySign(Map<String, Object> params){
        /*String sign = String.valueOf(params.get("sign"));
        Long timestamp;
        try {
            timestamp = Long.valueOf(String.valueOf(params.get("timestamp")));
        } catch (NumberFormatException ex){
            throw new SignException();
        }

        if (new Date().getTime() - timestamp > TimeUtils.MILLISECONDS_OF_ONE_MINUTE * 30l)
            throw new TimeoutException();
        if (!SignUtils.verifySign(params))
            throw new SignException();
        */
    }
}
