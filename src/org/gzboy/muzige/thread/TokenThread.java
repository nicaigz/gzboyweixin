package org.gzboy.muzige.thread;

import org.gzboy.muzige.pojo.AccessToken;
import org.gzboy.muzige.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 定时获取微信access_token的线程
 * 
 * @author guozhe
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = "wx9245d2c53a0dc046";
	// 第三方用户唯一凭证密钥
	public static String appsecret = "e06844085f98b2bb0834aa650407d1e8";
	public static AccessToken accessToken = null;

	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());
					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}
		}
	}
}