# Test Plan — ba.com Login Module

> Generated using the RICE POT Generic QA Template (Profile B — Test Plan). This is a planning artifact. No tests described here have been executed. Requirement IDs are locally assigned for this plan and are not sourced from any British Airways system.

---

## 1. Test Plan ID and Title

| Field | Value |
| --- | --- |
| Test Plan ID | TP-BA-LOGIN-001 |
| Title | ba.com Login Module — Functional Test Plan |
| Version | 1.0 (Draft for review) |
| Author | QA Team (proposed) |
| Status | Draft — pending approval |
| Application | British Airways public website (ba.com) |
| Feature / Module | Login module (credentials sign-in) |

## 2. Objective and References

**Objective:** Verify that the ba.com login module correctly authenticates valid credentials and rejects invalid credentials, and that the login form renders its required controls, for the basic username/password sign-in flow.

**References:**
- Locally-assigned requirements BA-LOGIN-01 through BA-LOGIN-05 (see Section 4).
- RICE POT Generic QA Template, Profile B.
- Formal BA requirement documents, user stories, and acceptance criteria: **Not provided.**

## 3. In Scope and Out of Scope

**In scope**
- Basic credentials login: username / Executive Club identifier + password + sign-in action.
- Positive authentication (valid credentials).
- Negative authentication (incorrect password, unknown/invalid username).
- Required-field validation (empty fields prevent submission).
- Rendering of the login form's required UI elements.

**Out of scope**
- "Remember me" functionality.
- Forgotten username / PIN / password recovery flows.
- Social / third-party / SSO login.
- Multi-factor authentication (MFA) and OTP.
- Account lockout after repeated failed attempts.
- Account registration and enrolment.
- Booking, check-in, and any post-login journeys beyond confirming authenticated state.
- Performance, load, security/penetration, and accessibility testing.

## 4. Requirements and Planned Coverage

All requirement IDs below are **locally assigned for this plan** and are not sourced from a BA system.

| Requirement ID | Description | Scenario Type | Planned Coverage | Priority (proposed) |
| --- | --- | --- | --- | --- |
| BA-LOGIN-01 | A valid account with correct credentials is authenticated and reaches the authenticated account state. | Positive functional | 1+ case | High |
| BA-LOGIN-02 | A correct username with an incorrect password is rejected; no session is created. | Negative functional | 1+ case | High |
| BA-LOGIN-03 | An unknown or invalid username is rejected; no session is created. | Negative functional | 1+ case | Medium |
| BA-LOGIN-04 | Submitting with one or both required fields empty does not authenticate and surfaces validation. | Negative / validation | 1+ case | Medium |
| BA-LOGIN-05 | The login form renders its required controls (username field, password field, sign-in control). | UI / functional | 1+ case | Medium |

**Coverage note:** Exact on-screen error messages and the specific authenticated-state locator are **Not provided**. Expected results in derived test cases must be confirmed against observed application behavior before they are treated as authoritative.

## 5. Test Approach, Levels, and Types

- **Approach:** Manual and/or automated functional verification of the login flow against the proposed requirements, using positive and negative scenarios.
- **Test level:** System / UI level (end-user facing login page).
- **Test types applied (within scope):**
  - Functional testing (positive and negative).
  - Input validation testing (empty required fields).
  - UI presence/rendering checks for required controls.
- **Test types not applied (out of scope):** integration, regression suite execution beyond login, nonfunctional (performance, security, accessibility).
- **Automation candidate:** The scenarios align with a Selenium/Java or Playwright login suite using the Page Object Model; automation is optional and not required by this plan.

## 6. Environment, Tools, Access, and Test Data

| Item | Value |
| --- | --- |
| Environment | **Production** |
| URL | `https://www.ba.com` |
| Browser | Google Chrome (latest stable), Windows |
| Other browsers / devices | Not provided (out of scope for this plan) |
| Test management tool | Not provided |
| Defect tracker | Not provided (proposed: Jira) |
| Automation stack (if used) | Not provided (candidate: Selenium + Java + TestNG, or Playwright) |

**Test data and account prerequisites**

- A valid, provisioned synthetic account is **required** for BA-LOGIN-01.
- Credentials are **not** stored in this document. They must be supplied at run time through environment variables or an approved secret mechanism:
  - Username: `${BA_TEST_USERNAME}`
  - Password: `${BA_TEST_PASSWORD}`
- Negative cases (BA-LOGIN-02/03/04) use synthetic, non-valid input values (e.g. a wrong password for a known username, a non-existent username, blank fields).

> Security note: Do not commit real credentials to this repository or any shared document. Reference secrets only through the environment-variable placeholders above.

## 7. Entry and Exit Criteria

These thresholds are **proposed and require agreement.**

**Entry criteria**
- The ba.com login page is reachable in production via Chrome.
- A valid synthetic test account is provisioned and its credentials are available through the approved secret mechanism.
- Test data for negative cases is prepared.
- This test plan is reviewed and approved.

**Exit criteria**
- All five planned requirements (BA-LOGIN-01…05) have been executed.
- All High-priority cases pass.
- No open Critical or High-severity defects remain on the login flow.
- Test results and any defects are recorded and reported.

## 8. Roles, Responsibilities, Estimates, and Schedule

| Role | Responsibility | Owner |
| --- | --- | --- |
| Test Lead | Plan approval, scope sign-off, reporting | Not provided (proposed) |
| QA Engineer | Test case design, execution, defect logging | Not provided (proposed) |
| Developer | Defect triage and fixes | Not provided (proposed) |
| Product Owner | Requirement clarification, acceptance | Not provided (proposed) |

- **Estimates:** Not provided (proposed: small — 5 requirement-level scenarios).
- **Schedule / timeline:** Not provided (proposed; to be agreed with the team).

## 9. Defect Management and Reporting

- **Logging:** Defects raised in the agreed tracker (proposed: Jira) with environment, steps to reproduce, expected vs. actual result, evidence (screenshot), severity, and priority.
- **Severity/priority:** Proposed by QA at logging time; confirmed during triage.
- **Triage cadence:** Not provided (proposed: daily during the active test window).
- **Reporting cadence:** Not provided (proposed: a summary at the end of the test cycle covering executed vs. planned, pass/fail, and open defects).
- **Expected vs. actual behavior** are kept separate; a defect is not marked reproduced until reproduction is performed.

## 10. Risks, Dependencies, Assumptions, and Open Questions

**Risks**
- **Production testing risk (High):** Testing runs against live production (`https://www.ba.com`). Repeated invalid-login attempts may trigger real account lockout, rate-limiting, or security monitoring; valid logins touch a real account. Mitigation: keep testing minimal and non-destructive, use only approved synthetic accounts, avoid repeated failed attempts that could lock the account, and coordinate with the owning team.
- Absence of exact error-message text and authenticated-state locator may make some expected results ambiguous until confirmed against the application.

**Dependencies**
- Availability of the production login page and a provisioned synthetic test account.
- Chrome availability on the test machine.

**Assumptions (proposed, for agreement)**
- The login module exposes a username field, a password field, and a sign-in control.
- Invalid credentials result in a visible rejection and no authenticated session.

**Open questions**
- What is the exact expected behavior and message for incorrect password vs. unknown username?
- What observable state confirms a successful authenticated login?
- Is any non-production (staging) environment available to reduce production-testing risk?
- Who are the responsible owners for the roles in Section 8?

## 11. Suspension and Resumption Criteria

**Suspension**
- The production login page is unreachable or returns errors unrelated to the test data.
- The test account becomes locked or de-provisioned.
- A Critical defect blocks the login flow end to end.
- Production-impact concerns are raised by the owning team.

**Resumption**
- The blocking condition is resolved (page reachable, account restored/unlocked, blocking defect fixed) and verified, and the team authorizes continuation.

## 12. Test Deliverables and Approval

**Deliverables**
- This test plan (`05_Test_Plan_RICE_POT_Template.md`).
- Derived test cases for BA-LOGIN-01…05 (separate artifact — not included here).
- Test execution results and defect reports (produced during execution — not included here).

**Approval**

| Name | Role | Decision | Date |
| --- | --- | --- | --- |
| _TBD_ | Test Lead | Pending | _TBD_ |
| _TBD_ | Product Owner | Pending | _TBD_ |

---

### Plan status summary

- **Generated:** Yes — this planning document.
- **Reviewed:** Pending stakeholder review.
- **Executed:** No. No test execution, pass/fail results, or production-readiness claims are made in this plan.
