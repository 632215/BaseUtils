package weis.www.baseframe.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 文字（禁止emj表情文字）
 * <p>
 * Created by Administrator on 2018/2/1.
 */

public class EmjolEditText extends EditText {
    private static String tips = "暂不支持表情";
    private int editStart;
    private Context context;
    private String beforeString = "";


    public EmjolEditText(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EmjolEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public EmjolEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    /**
     * 设置提示语
     *
     * @param tips
     */
    public void setTips(String tips) {
        this.tips = tips;
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                beforeString = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editStart = getSelectionStart();
                // 先去掉监听器，否则会出现栈溢出
                boolean flag = false;
                removeTextChangedListener(this);
                if (editable != null && !editable.toString().equals("")) {
                    int index = getSelectionStart() - 1;
                    if (index > 0) {
                        char cs = editable.charAt(index);
                        if (isEmojiCharacter(cs)) {
                            editable.clear();
                            editable.append(beforeString);
                            flag = true;
                            Toast.makeText(context, tips, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                setText(editable);
                if (flag)
                    setSelection(beforeString.length());
                else
                    setSelection(editStart);
                // 恢复监听器
                addTextChangedListener(this);
            }
        });
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint             比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint >= 0x2600 && codePoint <= 0x27BF) // 杂项符号与符号字体
                || codePoint == 0x303D
                || codePoint == 0x2049
                || codePoint == 0x203C
                || (codePoint >= 0x2000 && codePoint <= 0x200F)//
                || (codePoint >= 0x2028 && codePoint <= 0x202F)//
                || codePoint == 0x205F //
                || (codePoint >= 0x2065 && codePoint <= 0x206F)//
                /* 标点符号占用区域 */
                || (codePoint >= 0x2100 && codePoint <= 0x214F)// 字母符号
                || (codePoint >= 0x2300 && codePoint <= 0x23FF)// 各种技术符号
                || (codePoint >= 0x2B00 && codePoint <= 0x2BFF)// 箭头A
                || (codePoint >= 0x2900 && codePoint <= 0x297F)// 箭头B
                || (codePoint >= 0x3200 && codePoint <= 0x32FF)// 中文符号
                || (codePoint >= 0xD800 && codePoint <= 0xDFFF)// 高低位替代符保留区域
                || (codePoint >= 0xE000 && codePoint <= 0xF8FF)// 私有保留区域
                || (codePoint >= 0xFE00 && codePoint <= 0xFE0F)// 变异选择器
                || codePoint >= 0x10000; // Plane在第二平面以上的，char都不可以存，全部都转
    }
}
