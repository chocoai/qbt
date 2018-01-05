package com.qbt.common.util;

/** 
 *  
 */

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.qbt.common.logback.LogCvt;

/**
 * RSA 工具类。提供加密，解密，生成密钥对等方法。
 * 
 */
public class RSAUtil {

	final private static int	KEY_SIZE	= 1024;

	final private static BouncyCastleProvider provider = new BouncyCastleProvider();
	
	private static KeyPair		keyPair		= null;

	/**
	 * 用于解密客户端javascript RSA加密的密文
	 * 
	 * @param encrypt
	 *            密文
	 * @return
	 */
	public static String decrypt(String encrypt) {
		KeyPair keyPair = getKeyPair();
		StringBuffer sb = new StringBuffer();
		byte[] debyte;
		try {
			byte[] enbyte = RSAUtil.hexStringToBytes(encrypt);
			debyte = RSAUtil.decrypt(keyPair.getPrivate(), enbyte);
			sb.append(new String(debyte));
		} catch (Exception e) {
			LogCvt.error("RSA解密失败.", e);
		}
		return sb.reverse().toString();
	}

	public static synchronized KeyPair getKeyPair(String storePath) {
		if (null == keyPair) {
			try {
				keyPair = RSAUtil.readKeyPair(storePath);
			} catch (Exception e) {
				LogCvt.error("获取RSA密钥失败.", e);
			}
		}
		return keyPair;
	}
	
	public static KeyPair getKeyPair() {
		return keyPair;
	}

	/**
	 * * 生成密钥对
	 * 
	 * @return KeyPair
	 * @throws EncryptException
	 */
	public static KeyPair generateKeyPair() throws Exception {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA", provider);
			keyPairGen.initialize(KEY_SIZE, new SecureRandom());
			KeyPair keyPair = keyPairGen.generateKeyPair();
			return keyPair;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static String getPublicKeyModulus(KeyPair keypair) {
		RSAPublicKey rsapubkey = (RSAPublicKey) keypair.getPublic();
		return rsapubkey.getModulus().toString(16);
	}

	public static BigInteger getPublicKeyExponent(KeyPair keypair) {
		RSAPublicKey rsapubkey = (RSAPublicKey) keypair.getPublic();
		return rsapubkey.getPublicExponent();
	}

	public static KeyPair readKeyPair(String storePath) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storePath));
		Object obj = ois.readObject();
		ois.close();
		if (null != obj && obj instanceof KeyPair) {
			return (KeyPair) obj;
		}
		return null;
	}

	public static void saveKeyPair(KeyPair kp, String storePath) throws Exception {
		FileOutputStream fos = new FileOutputStream(storePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 生成密钥
		oos.writeObject(kp);
		oos.close();
		fos.close();
	}

	/**
	 * * 生成公钥 *
	 * 
	 * @param modulus
	 *            *
	 * @param publicExponent
	 *            *
	 * @return RSAPublicKey *
	 * @throws Exception
	 */
	public static RSAPublicKey generateRSAPublicKey(byte[] modulus, byte[] publicExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA", provider);
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
		try {
			return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * * 生成私钥 *
	 * 
	 * @param modulus
	 *            *
	 * @param privateExponent
	 *            *
	 * @return RSAPrivateKey *
	 * @throws Exception
	 */
	public static RSAPrivateKey generateRSAPrivateKey(byte[] modulus, byte[] privateExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA", provider);
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(privateExponent));
		try {
			return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * * 加密 *
	 * 
	 * @param key
	 *            加密的密钥 *
	 * @param data
	 *            待加密的明文数据 *
	 * @return 加密后的数据 *
	 * @throws Exception
	 */
	public static byte[] encrypt(PublicKey pk, byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", provider);
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * * 解密 *
	 * 
	 * @param key
	 *            解密的密钥 *
	 * @param raw
	 *            已经加密的数据 *
	 * @return 解密后的明文 *
	 * @throws Exception
	 */
	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", provider);
			cipher.init(cipher.DECRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
//	public static void main(String[] args) throws Exception {
//	    KeyPair keyPairInit = generateKeyPair();
//	    saveKeyPair(keyPairInit, "D:/rsa_key.dat");
//    }

	/**
	 * * *
	 * 
	 * @param args
	 *            *
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String RSAKeyStore = "/Volumes/work/iamp_rsa_key.dat";
		KeyPair keypair = RSAUtil.readKeyPair(RSAKeyStore);
		System.out.println(keypair.getPublic());

		String encode = "1ed29e743490aeb559e31efecaab66ae69043cec78eddec64a686c01fa0fe1f8e627c7efb431a2c2abed4d90bfdddc9fb944c1b7a349ced751f9fd092d9a3bbf707a6d8f5a49699f39c63c018df51d630559317a9907d50594399f85e1c53685474df650ec32779891a6b1d08546071903014db148aa92694a2da34c429d681e";
		byte[] enbyte = hexStringToBytes(encode);
		byte[] debyte = decrypt(keypair.getPrivate(), enbyte);

		StringBuffer sb = new StringBuffer();
		sb.append(new String(debyte));
		System.out.println(sb.reverse().toString());

	}

	
}