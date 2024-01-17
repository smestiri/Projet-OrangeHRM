##language: en

Feature: Test création PIM

  @aLancer
  Scenario Outline: Cas passant de création de PIM
    Given je vais sur la page web "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And je renseigne un username "<username>"
    And je renseigne un mot de passe "<mot de passe>"
    And je clique sur le bouton connexion
    And je clique sur PIM
    And je clique sur le bouton ADD
    And je renseigne un firstname "<firstname>"
    And je renseigne un middlename "<middlename>"
    And je renseigne un lastname "<lastname>"
    And je clique sur le bouton create login details
    And je renseigne un username details "<usernamedetails>"
    And je reseigne un password details "<passworddetails>"
    When je confirme le password details "<Confpassworddetails>"
    Then je clique sur le bouton save pour valider la création

    Examples:
      | username | mot de passe | firstname | middlename | lastname |usernamedetails|passworddetails|Confpassworddetails|
      | Admin    | admin123     | Sirine    |  sirine    |Mestiri   |     mestiri   |   Mestiri123  |   Mestiri123      |
