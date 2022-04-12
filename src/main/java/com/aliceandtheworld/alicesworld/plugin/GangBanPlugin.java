package com.aliceandtheworld.alicesworld.plugin;

import com.mikuac.shiro.common.utils.MsgUtils;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class GangBanPlugin extends BotPlugin {
	MsgUtils sendMsg;

	@Override
	public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
		String messageRaw = event.getRawMessage();
		if (messageRaw.equals("钢板")){
		    sendMsg = MsgUtils.builder().tts("好耶我是");
			bot.sendGroupMsg(event.getGroupId(), sendMsg.build(), false);
		}
		return MESSAGE_IGNORE;
	}
}
