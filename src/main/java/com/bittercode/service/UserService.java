    public User login(UserRole role, String email, String password) throws StoreException;
    /**
     * Stateless service – session management is handled at the web tier
     * using an external store (e.g. Azure Cache for Redis).
     */
    public boolean logout(HttpSession session);

}
