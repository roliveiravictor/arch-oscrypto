[![MKT](https://img.shields.io/badge/version-v1.0.0-blue.svg)](https://img.shields.io/badge/version-v1.0.0-blue.svg)
[![MKT](https://img.shields.io/badge/language-Java-orange.svg)](https://img.shields.io/badge/language-Java-orange.svg)
[![MKT](https://img.shields.io/badge/platform-Android-lightgrey.svg)](https://img.shields.io/badge/platform-Android-lightgrey.svg)
[![MKT](https://img.shields.io/badge/license-Copyleft-red.svg)](./LICENSE)

# Content

[1 - Description](#description)

[2 - IDE](#ide)

[3 - Objective](#objective)

[4 - Composition](#composition)

[5 - Run](#run)

[6 - Requirements](#requirements)

[7 - Usage](#usage)

[8 - Singletons](#singletons)

[9 - References](#references)

[10 - Forthcoming Work](#forthcoming)

# Description

-   OS Local Crypto. Android Architecture SDK.

# IDE

-   Android Studio 3.2.1
-   Build #AI-181.5540.7.32.5056338, built on October 8, 2018
-   JRE: 1.8.0_152-release-1136-b06 x86_64
-   JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
-   macOS 10.14

# Objective

  -   Cryptography SDK derived from java.
  -   The main ideas are:

      1. Generate local and independent crypto.
      2. Provide an independent and secure way to hide data.

# Overview

   * N/A

# Composition

  - SDK is total native.

# Run

  -   Clone this repository and open build.gradle with Android Studio

# Requirements

  -   minSdkVersion 19
  -   targetSdkVersion 26
  -   compileSdkVersion 26
  -   buildToolsVersion 26.0.3

# Usage

### 1 - Generate key

```
OSCryptoHelper.start(context);
```

- After generating the key (e.g. first call inside onCreate), you may freely call step 2 and 3.

### 2 - Encrypt

```
OSCryptoHelper.encrypt("<To encrypt text goes here>");
```

### 3 - Decrypt

```
OSCryptoHelper.decrypt("<To decrypt text goes here>");
```

# Singletons

* N/A

#   References:

- https://stackoverflow.com/questions/40123319/easy-way-to-encrypt-decrypt-string-in-android
- https://stackoverflow.com/questions/13433529/android-4-2-broke-my-encrypt-decrypt-code-and-the-provided-solutions-dont-work/39002997#39002997
- https://stackoverflow.com/questions/184112/what-is-the-optimal-length-for-user-password-salt
- https://stackoverflow.com/questions/7046997/arent-private-keys-vulnerable-in-memory
- https://crypto.stackexchange.com/questions/40534/what-is-the-use-of-key-iterations

#   Contact:

- roliveira.victor@gmail.com

#   Forthcoming Work:

- Support more than just AES-256.

#   Buy me a coffee ;)

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=RGQ8NSYPA59FL)