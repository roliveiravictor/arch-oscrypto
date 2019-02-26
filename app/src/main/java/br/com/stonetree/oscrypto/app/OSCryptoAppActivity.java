package br.com.stonetree.oscrypto.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.stonetree.oscrypto.helper.OSCryptoHelper;

public class OSCryptoAppActivity extends AppCompatActivity {

    private TextView clear;
    private TextView encrypted;
    private TextView decrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(br.com.stonetree.oscrypto.app.R.layout.activity_oscrypto_app);
        findViews();

        OSCryptoHelper.start(this);

        setClearText();
        setEncryptedText();
        setDecryptedText();
    }

    private void setClearText() {
        clear.setText("This is my clear text.");
    }

    private void setEncryptedText() {
        final String encrytedStr = OSCryptoHelper.encrypt("This is my clear text.");
        if (!encrytedStr.isEmpty())
            encrypted.setText("### Below is the above text encrypted ### \n\n" + encrytedStr);
    }

    private void setDecryptedText() {
        final String encrypted = OSCryptoHelper.encrypt("This is my clear text.");
        final String decryptedStr = OSCryptoHelper.decrypt(encrypted);
        if (!decryptedStr.isEmpty())
            decrypted.setText("### Below is the above text decrypted ### \n\n" + decryptedStr);
    }

    private void findViews() {
        clear = findViewById(br.com.stonetree.oscrypto.app.R.id.clearText);
        encrypted = findViewById(br.com.stonetree.oscrypto.app.R.id.encryptedText);
        decrypted = findViewById(br.com.stonetree.oscrypto.app.R.id.decryptedText);
    }

}
