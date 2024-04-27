package ma.xproce.music_mood_matcher.DAO.Services;


import java.util.List;

import ma.xproce.music_mood_matcher.DAO.Entities.Solution;

public interface SolutionManager {

    Solution createSolution(Solution solution);

    List<Solution> getAllSolutions();

    Solution getSolutionById(Integer id);

    Solution updateSolution(Solution solution);

    void deleteSolutionById(Integer id);
}

