package com.marcobehler.springmvcarticle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IpController {

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"};


    @GetMapping("/ip")
    public String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return getRealClientIpAddress(ip);
            }
        }
        return request.getRemoteAddr();
    }

    /**
     * Goes through the supplied ip string (could be one or multiple). Traverses it through the right side...
     * and removes any known ip address ranges
     *
     * @param ipString
     * @return
     */
    public String getRealClientIpAddress(String ipString) {
        String[] manyPossibleIps = ipString.split(",");

        for (int i = manyPossibleIps.length - 1; i >= 0; i--) {
            String rightMostIp = manyPossibleIps[i].trim();
            if (isKnownAddress(rightMostIp)) {
                continue; // skip this ip as it is trusted
            } else {
                return rightMostIp;
            }
        }

        return ipString;
    }

    private boolean isKnownAddress(String rightMostIp) {
        // do your check here..for cloudfront you'd need to download their ip address ranges
        // from e.g. http://d7uri8nf7uskq.cloudfront.net/tools/list-cloudfront-ips
        // and compare the current ip against them
        return false;
    }

}
