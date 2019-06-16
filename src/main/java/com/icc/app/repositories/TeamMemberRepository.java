package com.icc.app.repositories;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember,Long> {
    TeamMember findByTeamMemberId(Long teamMemberId);
}
