import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

    /**
     * Jedis connection pool for Azure Cache for Redis.
     *
     * Connection details are supplied via environment variables so that
     * they can be wired from Azure App Configuration / Key Vault.
     */

    private static final String REDIS_HOST = System.getenv("REDIS_HOST");
    private static final int REDIS_PORT = Integer.parseInt(System.getenv().getOrDefault("REDIS_PORT", "6379"));
    private static final String REDIS_PASSWORD = System.getenv("REDIS_PASSWORD");

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        if (REDIS_PASSWORD != null && !REDIS_PASSWORD.isEmpty()) {
            jedisPool = new JedisPool(poolConfig, REDIS_HOST, REDIS_PORT, 2000, REDIS_PASSWORD);
        } else {
            jedisPool = new JedisPool(poolConfig, REDIS_HOST, REDIS_PORT);
        }
    }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }

    private static String buildSessionKey(HttpSession session, String key) {
        return session.getId() + ":" + key;
    }
    public static boolean isLoggedIn(UserRole role, HttpSession session) {
        String redisKey = buildSessionKey(session, role.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(redisKey);
        }
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
            String items;
            try (Jedis jedis = jedisPool.getResource()) {
                items = jedis.get(buildSessionKey(session, "items"));
            }
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.set(buildSessionKey(session, "items"), items);
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    itemQty += 1;
                    jedis.set(qtyKey, String.valueOf(itemQty));
                }
                int itemQty = 0;
                String qtyKey = buildSessionKey(session, "qty_" + selectedBookId);
                try (Jedis jedis = jedisPool.getResource()) {
                    String qtyVal = jedis.get(qtyKey);
                    if (qtyVal != null) {
                        itemQty = Integer.parseInt(qtyVal);
                    }
                    if (itemQty > 1) {
                        itemQty--;
                        jedis.set(qtyKey, String.valueOf(itemQty));
                    } else {
                        jedis.del(qtyKey);
                        items = items.replace(selectedBookId + ",", "");
                        items = items.replace("," + selectedBookId, "");
                        items = items.replace(selectedBookId, "");
                        jedis.set(buildSessionKey(session, "items"), items);
                    }
                }
    public static void setActiveTab(PrintWriter pw, String activeTab) {

        pw.println("<script>document.getElementById(activeTab).classList.remove(\"active\");activeTab=" + activeTab
                + "</script>");
        pw.println("<script>document.getElementById('" + activeTab + "').classList.add(\"active\");</script>");

    }

    /**
     * Add/Remove/Update Item in the cart using the session
     */
    public static void updateCartItems(HttpServletRequest req) {
        String selectedBookId = req.getParameter("selectedBookId");
        HttpSession session = req.getSession();
        if (selectedBookId != null) { // add item to the cart

            // Items will contain comma separated bookIds that needs to be added in the cart
            String items = (String) session.getAttribute("items");
            if (req.getParameter("addToCart") != null) { // add to cart
                if (items == null || items.length() == 0)
                    items = selectedBookId;
                else if (!items.contains(selectedBookId))
                    items = items + "," + selectedBookId; // if items already contains bookId, don't add it

                // set the items in the session to be used later
                session.setAttribute("items", items);

                /*
                 * Quantity of each item in the cart will be stored in the session as:
                 * Prefixed with qty_ following its bookId
                 * For example 2 no. of book with id 'myBook' in the cart will be
                 * added to the session as qty_myBook=2
                 */
                int itemQty = 0;
                if (session.getAttribute("qty_" + selectedBookId) != null)
                    itemQty = (int) session.getAttribute("qty_" + selectedBookId);
                itemQty += 1;
                session.setAttribute("qty_" + selectedBookId, itemQty);
            } else { // remove from the cart
                int itemQty = 0;
                if (session.getAttribute("qty_" + selectedBookId) != null)
                    itemQty = (int) session.getAttribute("qty_" + selectedBookId);
                if (itemQty > 1) {
                    itemQty--;
                    session.setAttribute("qty_" + selectedBookId, itemQty);
                } else {
                    session.removeAttribute("qty_" + selectedBookId);
                    items = items.replace(selectedBookId + ",", "");
                    items = items.replace("," + selectedBookId, "");
                    items = items.replace(selectedBookId, "");
                    session.setAttribute("items", items);
                }
            }
        }

    }
}
