package com.adalabs.tokens.security;

public class SecurityConstants {
	public static final String SECRET = "SecretKeyToAdalabsJWTs";
	public static final long EXPIRATION_TIME = 900_000; // 15 minutes
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String REGISTER_URL = "/users/register";
}
