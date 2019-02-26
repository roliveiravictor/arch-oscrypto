package br.com.stonetree.oscrypto.helper;

import android.content.Context;
import android.util.Base64;

import java.io.InputStream;
import java.security.spec.KeySpec;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.AES;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.ALIAS_PBK;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.BLOCK_TYPE;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.EMPTY;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.FILE_NAME;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.FIRST_INDEX;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.ITERATIONS;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.IV_BREAKER;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.KEY_LENGTH;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.SALT_LENGTH;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.SECOND_INDEX;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.SEED;
import static br.com.stonetree.oscrypto.constants.OSCryptoConstants.UTF_8;

public class OSCryptoHelper {

    private static SecretKey key;

    public static void start(Context context) {
        final byte[] salt = new byte[SALT_LENGTH];
        final Properties properties = new Properties();
        try {
            final InputStream stream = context.getAssets().open(FILE_NAME);

            properties.load(stream);

            final String seed = properties.getProperty(SEED, EMPTY);
            final KeySpec keySpec = new PBEKeySpec(seed.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

            final SecretKeyFactory factory = SecretKeyFactory.getInstance(ALIAS_PBK);
            final byte[] keyBytes = factory.generateSecret(keySpec).getEncoded();

            key = new SecretKeySpec(keyBytes, AES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String input) {
        try {
            final byte[] clearBytes = input.getBytes(UTF_8);

            final Cipher cipher = Cipher.getInstance(BLOCK_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            final byte[] four = cipher.getIV();
            final byte[] encodedBytes = cipher.doFinal(clearBytes);

            final String fourText = Base64.encodeToString(four, Base64.DEFAULT);
            final String data = Base64.encodeToString(encodedBytes, Base64.DEFAULT);
            return fourText + IV_BREAKER + data;
        } catch (Exception e) {
            e.printStackTrace();
            return EMPTY;
        }
    }

    public static String decrypt(String input) {
        try {
            final String[] cryptoData = input.split(IV_BREAKER);
            final byte[] iv = (Base64.decode(cryptoData[FIRST_INDEX], Base64.DEFAULT));
            final byte[] data = Base64.decode(cryptoData[SECOND_INDEX], Base64.DEFAULT);

            final Cipher cipher = Cipher.getInstance(BLOCK_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

            byte[] decodedBytes = cipher.doFinal(data);

            return new String(decodedBytes, 0, decodedBytes.length, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return EMPTY;
        }
    }

}
