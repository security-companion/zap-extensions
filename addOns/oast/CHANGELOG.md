# Changelog

All notable changes to this add-on will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.2.0] - 2021-08-17
### Added
- An option to allow changing the polling frequency of BOAST servers.
- A table that lists the payloads and canary values of all registered BOAST servers.
- Two new scripts that demonstrate how to interact with this add-on:
  - OAST Register Request Handler.js (Template)
  - OAST Get BOAST Servers.js

### Removed
- The _ID_ and the _Canary Value_ fields, in favour of the _Active Servers_ table in the BOAST options window.

## [0.1.1] - 2021-08-04
### Fixed
- Requests were not showing up in the OAST Callbacks panel.
- BOAST servers were not being polled after registration.

## [0.1.0] - 2021-08-04

[0.2.0]: https://github.com/zaproxy/zap-extensions/releases/oast-v0.2.0
[0.1.1]: https://github.com/zaproxy/zap-extensions/releases/oast-v0.1.1
[0.1.0]: https://github.com/zaproxy/zap-extensions/releases/oast-v0.1.0