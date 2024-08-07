package com.example.javadocker.Repository;

import com.example.javadocker.Model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
}
