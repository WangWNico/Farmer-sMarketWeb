package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class FarmersMarketController {

    DatabaseModel databaseModel;

    @Autowired
    private FarmersMarketRepository farmersMarketRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public Page<FarmersMarket> getAllMarkets(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return farmersMarketRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public FarmersMarket getMarketById(@PathVariable int id) {
        return farmersMarketRepository.findById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Integer> findMarkets(@RequestParam(required = false) String city, @RequestParam(required = false) String state, @RequestParam(required = false) String zip, @RequestParam(required = false) Integer distance) {
        // Implement search logic here
        return List.of(); // Placeholder
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        // Update average rating and review count
        FarmersMarket market = farmersMarketRepository.findById(review.getFMID()).orElse(null);
        if (market != null) {
            market.setReview_count(market.getReview_count() + 1);
            market.setAverage_rating((market.getAverage_rating() * (market.getReview_count() - 1) + review.getRating()) / market.getReview_count());
            farmersMarketRepository.save(market);
        }
        return reviewRepository.save(review);
    }

    @PostMapping("/generate-database")
    public String generateDatabase() {
        try {
            databaseModel.generateTables();
            return "Database tables generated successfully.";
        } catch (Exception e) {
            return "Error generating database tables: " + e.getMessage();
        }
    }

}