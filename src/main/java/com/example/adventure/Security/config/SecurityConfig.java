package com.example.adventure.Security.config;
// basic authorization. Virker i backenden, men ikke med frontenden
    /*@Override

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter{
    auth.inMemoryAuthentication()
    .withUser("admin")
    .password("admin")
    .roles("admin_role");
    }
     */

//    protected void configure(HttpSecurity http) throws Exception{
//        httpBasic()
//        .and()
//        .authorizeRequests()
//        .antMatchers("/api/v1/**).hasRole("admin_role")
//        .and()
//        .formLogin();
//        }
//      @Bean
//      public PasswordEncoder getPasswordEncoder()
//      {return NoOpPasswordEncoder.getInstance();}
//
//








// et forsøg på at lave authorization med JWT
//@AllArgsConstructor
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin")
//                .password("ADMIN")
//                .roles("ADMIN")
//        ;
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/api/v1/**").hasRole("ADMIN")
//                .antMatchers("/api/v1/").permitAll()
//                .anyRequest().authenticated();
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//
//    private final PasswordEncoder encoder;
//
//
//
//
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails adminUser = User.builder()
//                .username("admin")
//                .password(encoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(adminUser);
//    }


