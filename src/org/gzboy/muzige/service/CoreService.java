package org.gzboy.muzige.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gzboy.muzige.message.resp.TextMessage;
import org.gzboy.muzige.util.MessageUtil;
import org.gzboy.muzige.message.resp.Article;
import org.gzboy.muzige.message.resp.Music;
import org.gzboy.muzige.message.resp.MusicMessage;
import org.gzboy.muzige.message.resp.NewsMessage;

/**
 * 核心服务类
 * 
 * @author BI_GUOZHE
 * @date 2014-05-20
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 接收到的文本消息内容
				String msgContent = requestMap.get("Content");
				MenuService menuService = new MenuService();
				// 判断用户发送的是否是单个QQ表情
				if (menuService.isQqFace(msgContent)) {
					// 用户发什么QQ表情，就返回什么QQ表情
					respContent = msgContent;
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					// 如果不是qq表情，判斷用戶發送的內容如果以翻译二字开头，则翻译
				} else if (msgContent.equals("1")) {
					respContent = "最新商品和优惠信息";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("2")) {
					respContent = "您的集赞个数为：80个";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("3")) {
					respContent = "点此链接查询快递信息：http://m.kuaidi100.com";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("4")) {
					respContent = "本店铺地址为：河南省商丘市步行街经典广场木果果木专营店。（此处可添加百度地图链接）";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("5")) {
					respContent = "请把以下信息复制后修为自己的信息然后发送给我吧\n\n#会员信息:尕果果,女,1993-05-14,15851866595";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("6")) {
					respContent = "发送“#集赞个数：赞的个数”，发送后需要附上截图供审核\n集赞方式：转发店主微信，或者穿本店衣服晒单发到朋友圈集赞均有效，\n使用方法：满50个赞可获精美礼品一份或者9折优惠二选一";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("7")) {
					respContent = MenuService.getTranslateUsage();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("8")) {
					respContent = TodayInHistoryService.getTodayInHistoryInfo();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("9")) {
					respContent = MenuService.getMusicUsage();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.startsWith("#会员信息")) {
					if (UserService.UserUpdate(requestMap)) {
						String user_info = UserService.UserSelect(requestMap);
						respContent = "会员信息更新成功,具体信息如下:\n\n" + user_info
								+ "如果有错误请重新输入或者联系管理员";
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				} else if (msgContent.startsWith("#集赞个数")) {
					respContent = "收集赞成功";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.startsWith("翻译")) {
					String keyWord = msgContent.replaceAll("^翻译", "").trim();
					if ("".equals(keyWord)) {
						// 回复文本消息
						respContent = MenuService.getTranslateUsage();
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else {
						respContent = BaiduTranslateService.translate(keyWord);
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				} else if (msgContent.startsWith("歌曲")) {
					// 将歌曲2个字及歌曲后面的+、空格、-等特殊符号去掉
					String keyWord = msgContent.replaceAll(
							"^歌曲[\\+ ~!@#%^-_=]?", "");
					// 如果歌曲名称为空
					if ("".equals(keyWord)) {
						respContent = MenuService.getMusicUsage();
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else {
						String[] kwArr = keyWord.split("@");
						// 歌曲名称
						String musicTitle = kwArr[0];
						// 演唱者默认为空
						String musicAuthor = "";
						if (2 == kwArr.length) {
							musicAuthor = kwArr[1];
						}
						// 搜索音乐
						Music music = BaiduMusicService.searchMusic(musicTitle,
								musicAuthor);
						// 未搜索到音乐
						if (null == music) {
							respContent = "对不起，没有找到你想听的歌曲<" + musicTitle + ">。";
							TextMessage textMessage = new TextMessage();
							textMessage.setToUserName(fromUserName);
							textMessage.setFromUserName(toUserName);
							textMessage.setCreateTime(new Date().getTime());
							textMessage
									.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
							textMessage.setFuncFlag(0);
							textMessage.setContent(respContent);
							respMessage = MessageUtil
									.textMessageToXml(textMessage);
						} else {
							// 音乐消息
							MusicMessage musicMessage = new MusicMessage();
							musicMessage.setToUserName(fromUserName);
							musicMessage.setFromUserName(toUserName);
							musicMessage.setCreateTime(new Date().getTime());
							musicMessage
									.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
							musicMessage.setMusic(music);
							respMessage = MessageUtil
									.musicMessageToXml(musicMessage);
						}
					}
				} else if (msgContent.equals("10")) {
					// 创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setFuncFlag(0);
					List<Article> articleList = new ArrayList<Article>();
					Article article1 = new Article();
					article1.setTitle("生活服务");
					article1.setDescription("");
					// 将图片置为空
					article1.setPicUrl("");
					article1.setUrl("http://gzboyweixin.sinaapp.com");
					Article article2 = new Article();
					article2.setTitle("歌曲点播操作指南\n\n回复：歌曲+歌名\n例如：歌曲存在\n或者：歌曲存在@汪峰");
					article2.setDescription("");
					article2.setPicUrl("http://1.gzboyweixin.sinaapp.com/image/yinyue.jpg");
					article2.setUrl("");
					Article article3 = new Article();
					article3.setTitle("Q译通使用指南\n\nQ译通为用户提供专业的多语言翻译服务，目前支持以下翻译方向：\n    中 -> 英\n    英 -> 中\n    日 -> 中\n\n使用示例：\n    翻译我是中国人\n    翻译dream\n    翻译さようなら");
					article3.setDescription("");
					article3.setPicUrl("http://1.gzboyweixin.sinaapp.com/image/fanyi.png");
					article3.setUrl("");
					Article article4 = new Article();
					article4.setTitle("发送？查看主菜单");
					article4.setDescription("");
					article4.setPicUrl("");
					article4.setUrl("http://gzboyweixin.sinaapp.com");
					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (msgContent.equals("?") || msgContent.equals("？")) {
					respContent = MenuService.getMainMenu();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// respContent = menuService.MenuRequest(requestMap);
				// 图片消息
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					if (UserService.UserAdd(requestMap)) {
						respContent = "谢谢您的关注，为了更好的为您服务请尽快完善个人信息；可以通过发送“?”来查看菜单和使用方法！";
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
//					String eventKey = requestMap.get("EventKey");
//
//					if (eventKey.equals("11")) {
//						respContent = "天气预报菜单项被点击！";
//					} else if (eventKey.equals("12")) {
//						respContent = "公交查询菜单项被点击！";
//					} else if (eventKey.equals("13")) {
//						respContent = "周边搜索菜单项被点击！";
//					} else if (eventKey.equals("14")) {
//						respContent = "历史上的今天菜单项被点击！";
//					} else if (eventKey.equals("21")) {
//						respContent = "歌曲点播菜单项被点击！";
//					} else if (eventKey.equals("22")) {
//						respContent = "经典游戏菜单项被点击！";
//					} else if (eventKey.equals("23")) {
//						respContent = "美女电台菜单项被点击！";
//					} else if (eventKey.equals("24")) {
//						respContent = "人脸识别菜单项被点击！";
//					} else if (eventKey.equals("25")) {
//						respContent = "聊天唠嗑菜单项被点击！";
//					} else if (eventKey.equals("31")) {
//						respContent = "Q友圈菜单项被点击！";
//					} else if (eventKey.equals("32")) {
//						respContent = "电影排行榜菜单项被点击！";
//					} else if (eventKey.equals("33")) {
//						respContent = "幽默笑话菜单项被点击！";
//					}
				}
			}
			// textMessage.setContent(respContent);
			// respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}
