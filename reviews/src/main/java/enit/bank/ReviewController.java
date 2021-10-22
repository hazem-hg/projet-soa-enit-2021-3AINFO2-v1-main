import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @GetMapping(value="/Produits/{id}")
    public Review afficherReview(@PathVariable int id) {
        Review review=new Review(note=3, rev='not bad' );
        var review1 = review;
        return review1;
    }


}