package ma.xproce.music_mood_matcher.DAO.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ma.xproce.music_mood_matcher.DAO.Entities.Solution;
import ma.xproce.music_mood_matcher.DAO.Repositories.solutionRepository;

@Service
public class SolutionService {

    @Autowired
    private solutionRepository solutionRepository;

    public Solution createSolution(Solution solution) {
        return solutionRepository.save(solution);
    }

    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    public Solution getSolutionById(Integer id) {
        return solutionRepository.findById(id).orElse(null);
    }

    public Solution updateSolution(Solution solution) {
       
        Solution existingSolution = solutionRepository.findById(solution.getId()).orElse(null);
        if (existingSolution == null) {
           
            return null;
        }

        existingSolution.setMood(solution.getMood());  // Update mood reference
        return solutionRepository.save(existingSolution);
    }

    public void deleteSolutionById(Integer id) {
        solutionRepository.deleteById(id);
    }
}
