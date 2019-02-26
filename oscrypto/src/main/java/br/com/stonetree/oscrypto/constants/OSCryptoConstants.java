package br.com.stonetree.oscrypto.constants;

public class OSCryptoConstants {

    public static final String AES = "AES";
    public static final String BLOCK_TYPE = "AES/CBC/PKCS7Padding";
    public static final String UTF_8 = "UTF-8";
    public static final String EMPTY = "";
    public static final String ALIAS_PBK = "PBKDF2WithHmacSHA1";

    public static final String IV_BREAKER = "_!_";

    public static final String SEED = "seed";
    public static final String FILE_NAME = "local.properties";

    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;

    /**
     * Bytes - should be the same size as the output (256 / 8 = 32)
     **/
    public static final int SALT_LENGTH = 32;

    /**
     * 256-bits for AES-256, 128-bits for AES-128, etc
     **/
    public static final int KEY_LENGTH = 256;

    /**
     * Further doubts please check references inside README.md
     **/
    public static final int ITERATIONS = 1000;

}
