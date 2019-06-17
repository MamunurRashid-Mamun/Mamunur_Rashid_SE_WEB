package com.icc.app.repositories;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember,Long> {
    TeamMember findByTeamMemberId(Long teamMemberId);
    List<TeamMember> findByCountry(Country country);
    void deleteByTeamMemberId(Long teamMemberId);
    @Transactional
    void  deleteByCountry(Country country);
}
