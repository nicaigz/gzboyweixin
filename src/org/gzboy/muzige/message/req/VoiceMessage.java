package org.gzboy.muzige.message.req;

/**
 * ��Ƶ��Ϣ
 * 
 * @author BI_GUOZHE
 * @date 2014-05-19
 */
public class VoiceMessage extends BaseMessage {
	// ý��ID
	private String MediaId;
	// ������ʽ
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
