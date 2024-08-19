package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class for handling web requests related to the farmers market.
 */
@Controller
public class FarmersMarketWebController {

    private DatabaseModel databaseModel;

    /**
     * Constructor for FarmersMarketWebController.
     * Initializes the DatabaseModel instance.
     */
    public FarmersMarketWebController() {
        databaseModel = new DatabaseModel();
    }

    /**
     * Handles requests to the root URL ("/").
     * Retrieves a list of markets based on the provided page and query parameters.
     *
     * @param page  The page number for pagination (default is 1).
     * @param query The search query string (default is an empty string).
     * @param model The Model object to pass attributes to the view.
     * @return The name of the view to render.
     */
    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String query, Model model) {
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        List<String> markets = new ArrayList<>();
        try {
            ResultSet rs = databaseModel.searchMarkets(query, offset, pageSize);
            while (rs.next()) {
                markets.add(rs.getString("MarketName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("markets", markets);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("hasNextPage", markets.size() == pageSize);
        model.addAttribute("query", query);
        return "index";
    }

    /**
     * Handles search requests to the "/search" URL.
     * Redirects to the index method with the provided query.
     *
     * @param query The search query string.
     * @param model The Model object to pass attributes to the view.
     * @return The name of the view to render.
     */
    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        return index(1, query, model);
    }

    /**
     * Handles requests to the "/marketDetailByName" URL.
     * Retrieves the details of a specific market by its name and passes them to the model.
     *
     * @param marketName The name of the market to retrieve details for.
     * @param model      The Model object to pass attributes to the view.
     * @return The name of the view to render.
     */
    @GetMapping("/marketDetailByName")
    public String marketDetailByName(@RequestParam String marketName, Model model) {
        try {
            ResultSet rs = databaseModel.getMarketDetails(marketName);
            if (rs.next()) {
                Map<String, Object> market = new HashMap<>();
                market.put("marketName", rs.getString("MarketName"));
                market.put("website", rs.getString("Website"));
                market.put("street", rs.getString("street"));
                market.put("city", rs.getString("city"));
                market.put("state", rs.getString("State"));
                market.put("zip", rs.getString("zip"));
                market.put("season1Date", rs.getString("Season1Date"));
                market.put("season1Time", rs.getString("Season1Time"));
                market.put("season2Date", rs.getString("Season2Date"));
                market.put("season2Time", rs.getString("Season2Time"));
                market.put("season3Date", rs.getString("Season3Date"));
                market.put("season3Time", rs.getString("Season3Time"));
                market.put("season4Date", rs.getString("Season4Date"));
                market.put("season4Time", rs.getString("Season4Time"));
                market.put("x", rs.getBigDecimal("x"));
                market.put("y", rs.getBigDecimal("y"));
                market.put("location", rs.getString("Location"));
                market.put("credit", rs.getBoolean("Credit"));
                market.put("wic", rs.getBoolean("WIC"));
                market.put("wicCash", rs.getBoolean("WICcash"));
                market.put("sfmnp", rs.getBoolean("SFMNP"));
                market.put("snap", rs.getBoolean("SNAP"));
                market.put("organic", rs.getBoolean("Organic"));
                market.put("updateTime", rs.getString("updateTime"));

                // Fetch products for the market
                String[] productFields = {
                        "Bakedgoods", "Cheese", "Crafts", "Flowers", "Eggs", "Seafood", "Herbs", "Vegetables", "Honey", "Jams", "Maple", "Meat", "Nursery", "Nuts", "Plants", "Poultry", "Prepared", "Soap", "Trees", "Wine", "Coffee", "Beans", "Fruits", "Grains", "Juices", "Mushrooms", "PetFood", "Tofu", "WildHarvested"
                };
                String[] productNames = {
                        "Baked Goods", "Cheese", "Crafts", "Flowers", "Eggs", "Seafood", "Herbs", "Vegetables", "Honey", "Jams", "Maple", "Meat", "Nursery", "Nuts", "Plants", "Poultry", "Prepared", "Soap", "Trees", "Wine", "Coffee", "Beans", "Fruits", "Grains", "Juices", "Mushrooms", "Pet Food", "Tofu", "Wild Harvested"
                };

                StringBuilder products = new StringBuilder();
                for (int i = 0; i < productFields.length; i++) {
                    if (rs.getBoolean(productFields[i])) {
                        if (products.length() > 0) {
                            products.append(", ");
                        }
                        products.append(productNames[i]);
                    }
                }

                market.put("products", products.toString());
                model.addAttribute("market", market);
            } else {
                model.addAttribute("market", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("market", null);
        }
        return "marketDetail";
    }
}