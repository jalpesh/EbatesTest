# EbatesTest

The app fetches only the first page of recent images from flickr and displays them in a list view.

On fetching the list, the app fetches URls for higher size images. A default URL is generated using secret, farm id, server id and photoId. If large size image usrl is not returned as part of recent list, the default image URL is loaded.

On backpress the list os refrehed with latest images of recent.

Images are loaded using picasso library.

