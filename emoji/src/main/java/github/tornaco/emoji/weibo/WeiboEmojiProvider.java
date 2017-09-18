package github.tornaco.emoji.weibo;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import github.tornaco.span.handler.EmojiProvider;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class WeiboEmojiProvider implements EmojiProvider {

    private WeiboEmojiProvider() {
    }

    private static final Emoji[] DATA = new Emoji[]{
            new Emoji(R.drawable.d_feijie, "[费解]"),
            new Emoji(R.drawable.aini, "[爱你]")
    };

    private static final Map<String, Emoji> CACHED = new HashMap<>();

    private static final WeiboEmojiProvider sMe = new WeiboEmojiProvider();

    public static WeiboEmojiProvider getInstance() {
        return sMe;
    }

    @Override
    public Emoji getFromEmojiString(@NonNull String s) {
        Emoji cached = CACHED.get(s);
        if (cached != null) return cached;

        for (Emoji e : DATA) {
            if (e.getCode().equals(s)) {
                CACHED.put(s, e);
                return e;
            }
        }
        return null;
    }

    public void recycle() {
        CACHED.clear();
    }
}
