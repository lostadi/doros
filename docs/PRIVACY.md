# Privacy

Doros runs its simulation and rendering on your Android device. It does not
request Internet access and includes no advertising, analytics, accounts or
remote crash reporting. Without Internet permission, Android does not let it
send anything off the phone.

## What the app stores

Your selected controls and a randomly generated seed are kept in the app's
private Android preferences. The seed initializes the hidden Life world; it is
not an account or device identifier. Touch positions are used only for the
current moment, to draw nearby dots toward a touch, and are not saved.

The companion keeps a small separate memory: an affection value, the time the
wallpaper was last seen, and a cache of icon hues keyed by app package name.
Because that cache reveals which apps have appeared in your day, it is
**excluded from Android backup and device transfer** and never leaves the phone.

## Know my day (optional usage access)

If you turn on **Know my day** and grant Android's usage access, Doros reads,
once each time you return to the home screen, which apps were in the
foreground since you last saw it (at most the previous twelve hours, apps used
for at least fifteen seconds). It takes the dominant vivid colour of each app's
icon and releases up to four of those colours into the water. It does not read
notifications, messages, screen contents or anything inside other apps, and
keeps no record of usage times. Turn the switch off or revoke usage access in
Android's settings at any time.

## Permissions

- `SET_WALLPAPER` opens Android's wallpaper setup. The wallpaper service is
  protected by Android's `BIND_WALLPAPER` permission.
- `PACKAGE_USAGE_STATS` is used only for Know my day, and only after you grant
  usage access.
- `QUERY_ALL_PACKAGES` lets Doros look up the icons of apps you used.

Doros does not request access to your files, contacts, calendar, microphone,
camera, location, notifications or network. It writes local Android diagnostic
logs about rendering cost and simulation progress (including how many app
colours arrived, not which apps) and never transmits them.

## Removing app data

Clear Doros's storage in Android's app settings, or uninstall it, to remove its
preferences and the companion's memory.
