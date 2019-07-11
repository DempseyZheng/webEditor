package com.zcsxj.webeditor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener
{

    private RichEditor  mRichEditor;
    private ImageButton mActionUndo;
    private ImageButton mActionRedo;
    private ImageButton mActionInsertImage;
    String url = "https://c-ssl.duitang.com/uploads/item/201406/12/20140612202753_u4nG5.jpeg";
    /** 获取文本 */
    private Button mGetText;
//String html="";
String html="<p>呃呃<img src=\"https://c-ssl.duitang.com/uploads/item/201406/12/20140612202753_u4nG5.jpeg\" alt=\"aa\" " +
        "style=\"max-width: 100%;\">7天日期刚结婚uu✔:),&lt;&gt;</p><p>到底<img src=\"https://c-ssl.duitang" +
        ".com/uploads/item/201406/12/20140612202753_u4nG5.jpeg\" alt=\"aa\" style=\"max-width: 100%;\"><br></p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mRichEditor = (RichEditor) findViewById(R.id.rich_editor);
        mActionUndo = (ImageButton) findViewById(R.id.action_undo);
        mActionUndo.setOnClickListener(this);
        mActionRedo = (ImageButton) findViewById(R.id.action_redo);
        mActionRedo.setOnClickListener(this);
        mActionInsertImage = (ImageButton) findViewById(R.id.action_insert_image);
        mActionInsertImage.setOnClickListener(this);
        mGetText = (Button) findViewById(R.id.get_text);
        mGetText.setOnClickListener(this);
        mRichEditor.setHtml(html);
//        mRichEditor.post(new Runnable() {
//            @Override
//            public void run() {
//                if (TextUtils.isEmpty(html)){
//
//                mRichEditor.focusEditor();
//                }else {
//                    mRichEditor.setHtml(html);
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.action_undo:
                mRichEditor.undo();
                break;
            case R.id.action_redo:
                mRichEditor.redo();
                break;
            case R.id.action_insert_image:
                mRichEditor.insertImage(url, "aa");
                break;
            case R.id.get_text:
                mRichEditor.getText(new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        System.out.println(value);
                    }
                });
                mRichEditor.getHtml(new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        System.out.println(value);
                    }
                });
                break;
        }
    }
}
