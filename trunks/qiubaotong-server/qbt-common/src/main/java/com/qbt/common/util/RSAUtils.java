package com.qbt.common.util;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSAUtils {

	public static final String KEY_ALGORTHM="RSA";//
	public static final String SIGNATURE_ALGORITHM="MD5withRSA";
	
	public static final String PUBLIC_KEY = "RSAPublicKey";//公钥
	public static final String PRIVATE_KEY = "RSAPrivateKey";//私钥
	
	final private static BouncyCastleProvider provider = new BouncyCastleProvider();
	
	/** *//** 
     * RSA最大加密明文大小 
     */  
    private static final int MAX_ENCRYPT_BLOCK = 117;  
      
    /** *//** 
     * RSA最大解密密文大小 
     */  
    private static final int MAX_DECRYPT_BLOCK = 128;  
	
	/**
	 * 初始化密钥
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> initKey()throws Exception{
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORTHM,provider);
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		//公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		
		//私钥
		RSAPrivateKey privateKey =  (RSAPrivateKey) keyPair.getPrivate();
		
		Map<String,Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		
		return keyMap;
	}
	
	/**
	 * 取得公钥，并转化为String类型
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap)throws Exception{
		Key key = (Key) keyMap.get(PUBLIC_KEY);  
		return bytesToHexString(key.getEncoded());     
	}

	/**
	 * 取得私钥，并转化为String类型
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception{
		Key key = (Key) keyMap.get(PRIVATE_KEY);  
		return bytesToHexString(key.getEncoded());     
	}
	
	/**
	 * 用私钥加密
	 * @param data	加密数据
	 * @param key	密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data,String key)throws Exception{
		//解密密钥
		byte[] keyBytes = hexStringToBytes(key);
		//取私钥
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		
		//对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * 用私钥解密 * @param data 	加密数据
	 * @param key	密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey2(byte[] data,String key)throws Exception{
		//对私钥解密
		byte[] keyBytes = hexStringToBytes(key);
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		//对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		return cipher.doFinal(data);
	}
	
	/** *//** 
     * <P> 
     * 私钥解密 
     * </p> 
     *  
     * @param encryptedData 已加密数据 
     * @param privateKey 私钥(BASE64编码) 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String key) throws Exception {  
    	byte[] keyBytes = hexStringToBytes(key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);  
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateK);  
        int inputLen = encryptedData.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_DECRYPT_BLOCK;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return decryptedData;  
    }
	
	/**
	 * 用公钥加密
	 * @param data	加密数据
	 * @param key	密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data,String key)throws Exception{
		//对公钥解密
		byte[] keyBytes = hexStringToBytes(key);
		//取公钥
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		
		//对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * 用公钥解密
	 * @param data	加密数据
	 * @param key	密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data,String key)throws Exception{
		//对私钥解密
		byte[] keyBytes = hexStringToBytes(key);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		
		//对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 *	用私钥对信息生成数字签名
	 * @param data	//加密数据
	 * @param privateKey	//私钥
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data,String privateKey)throws Exception{
		//解密私钥
		byte[] keyBytes = hexStringToBytes(privateKey);
		//构造PKCS8EncodedKeySpec对象
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		//指定加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		//取私钥匙对象
		PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		//用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey2);
		signature.update(data);
		
		return bytesToHexString(signature.sign());
	}
	
	
	/**
	 * 校验数字签名
	 * @param data	加密数据
	 * @param publicKey	公钥
	 * @param sign	数字签名
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(byte[] data,String publicKey,String sign)throws Exception{
		//解密公钥
		byte[] keyBytes = hexStringToBytes(publicKey);
		//构造X509EncodedKeySpec对象
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		//指定加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM,provider);
		//取公钥匙对象
		PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);
		
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey2);
		signature.update(data);
		//验证签名是否正常
		return signature.verify(hexStringToBytes(sign));
		
	}
	
	public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
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
	
	public static void main(String[] args) throws Exception {
//		Map<String,Object> keyMap = initKey();
//		System.out.println(bytesToHexString(((RSAPublicKey)keyMap.get(PUBLIC_KEY)).getModulus().toByteArray()));
//		System.out.println(bytesToHexString(((RSAPublicKey)keyMap.get(PUBLIC_KEY)).getPublicExponent().toByteArray()));
//		System.out.println("public:"+getPublicKey(keyMap));
//		System.out.println("private:"+getPrivateKey(keyMap));
		
		String publickey  ="30819f300d06092a864886f70d010101050003818d00308189028181009823024fdd9b2571b68a286f694549996937f82d84340088a48fd553fc399d06b7cba9d46ecfd80b0a0cb570a415a66353608e7a9ee22e7d05c37c48bb61613f29a013d8122ba325e5f09229acb2b6fadebdb09eff07287c9d6f6a23ab5473050873b2b844432962e08a8eaa678159ddea594c5b73529c343f95b2104ed1a6290203010001";
		String privateKey ="30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a7bb33bb74f2852015cb02de5976b4a131f01c24ba40c3b92fc55479ec3e375d2f58ac9a829007ed4f15e0eb07fbf2e84f9c24139b3acaa803eaedbed8bf5edc07fc3c9c345c38788d7964238df7f1c85dfa32288912518b7d75a439ceab5c50798360cdf7041e1b66ada8727a75f835624721d54c8b6009a684606687c5dcf90203010001028180267a2141ed6ffcee0151d2d4a2fd422e80402e94964d6918c046aa3c55df67dfee8e8ef9dadda393e2c28818227abf9c5f36d867cf024b9f03570f36ea8debfa7a978027dd2245590cc563bc4b81ca4c3d5f60b8683f3e6b82bc3dcd5e21ebc4015abb9071fffbcc43088e10b0c2697334c0fae1450590ee9ed53220c3448ea9024100d4cc780edb5c117b3aef343128e8fa6fe48225b3c6a5797bfd70212cf37cfd47ae8345146557225b936d41411493cb93c5b5aaa99f1409e38fd549044e1b0eab024100c9c87f30cb902ae22d7aaee1242560e293e72c191059ffe4b4b5e9df5300b4245347d09c6ca63e649bd40d4377be839547a1091018037a730f3a91a55c3632eb0240730de253d6129f790b524ddbce8cb8eb4a977b9f09e66a1ab9daa8754f68e2e0a0e064b7345bba3ddd26134406c62a29c99a019e185e93423080572c36b6b665024079859b3c1acc675731c699fd935443861146fee2d55b2e666182d127a30860752406b31711c408fd746f7fd16b133c91b1c2c4ff8146cefeee63fa851904b723024100882d48186c91c42b0f5c9d033c8966ff44e78c581263067d3bcd46924729549a4dcfc55c8e1ab83fc3d1c05120025af8b19d2f8acf7478b20bee3ac30bf7c3cd";
////		
//		byte[] enpwd = encryptByPublicKey("111111".getBytes(), publickey);
//		String data = bytesToHexString(enpwd);
//		System.out.println(data);
		String data= "0f8d0c59fb6598dbea99778b49ac49b416fc962717734bcd636814bb2fdcd5709dfbeb4f2f464610062615dda3a6bd7500dffc8d8065314310b55501d0f0f82b33fc13966a0d5f24f6c4826621487cfd437be6dde3ac9cb7a17139e304d6e3ffbae1bab3fda404a376bb9231aafb54c04dfb72e2c48f7392aa747a12ef195283";
		byte[] test = decryptByPrivateKey(hexStringToBytes(data), privateKey);
//		
		System.out.println(new String(test));
	}
	
}
