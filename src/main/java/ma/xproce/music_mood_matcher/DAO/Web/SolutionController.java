package ma.xproce.music_mood_matcher.DAO.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.xproce.music_mood_matcher.DAO.Entities.Solution;
import ma.xproce.music_mood_matcher.DAO.Services.SolutionService;

@RestController
@RequestMapping("/api/solutions")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @PostMapping
    public Solution createSolution(@RequestBody Solution solution) {
        return solutionService.createSolution(solution);
    }

    @GetMapping
    public List<Solution> getAllSolutions() {
        return solutionService.getAllSolutions();
    }

    @GetMapping("/{id}")
    public Solution getSolutionById(@PathVariable Integer id) {
        return solutionService.getSolutionById(id);
    }

    @PutMapping("/{id}")
    public Solution updateSolution(@PathVariable Integer id, @RequestBody Solution solution) {
        solution.setId(id); 
        return solutionService.updateSolution(solution);
    }

    @DeleteMapping("/{id}")
    public void deleteSolutionById(@PathVariable Integer id) {
        solutionService.deleteSolutionById(id);
    }
}

